package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.front.CommonController;
import kr.or.ddit.front.HandlerInvoker;
import kr.or.ddit.front.HandlerMapper;
import kr.or.ddit.front.ViewResolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// ex) userList.do, rangersList.do ==>
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	private Logger logger = LoggerFactory.getLogger(FrontController.class);
	private HandlerMapper  handlerMapper;
	private HandlerInvoker handlerinvoker;
	private ViewResolver   viewResolver;
	
	@Override
	public void init() throws ServletException {
		handlerMapper  = new HandlerMapper();
		handlerinvoker = new HandlerInvoker();
		viewResolver   = new ViewResolver();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		logger.debug("FrontController doGet : {}", request.getRequestURI());
		
		//uri요청을 처리해 줄 컨트롤러 확인
		CommonController controller = handlerMapper.getController(request.getRequestURI());
		
		//컨트롤러 실행
		String viewInfo = handlerinvoker.invoke(request, response, controller);
		
		//viewResolver를 통한 응답 생성
		viewResolver.viewResolve(request, response, viewInfo);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
	
}
