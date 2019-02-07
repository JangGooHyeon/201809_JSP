package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.rangers.model.RangerVo;
import kr.or.ddit.rangers.service.RangersService;

@WebServlet("/rangersList")
public class RangersServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ServletContext application = getServletContext();

		// service객체를 이용하여 rengersList를 조회
		RangersService rangersService = new RangersService();
		List<String> rangersList = rangersService.getAll();
		List<RangerVo> rangersVoList = rangersService.getRangerVoAll();

		
		// 해당 데이터를 request 영역에 설정
		req.setAttribute("rangersList", rangersList);
		// vo객체의 속성을 session을 통해 설정
		session.setAttribute("rangersVoList", rangersVoList);
		
		
		//서로 다른 영역에 같은 이름을 갖는 속성을 정의
		req.setAttribute("userName", "brown_request");				//request attribute
		session.setAttribute("userName", "brown_session");			//session attribute
		application.setAttribute("userName", "brown_application");	//application attribute
		
//		session.removeAttribute("userName");
//		application.removeAttribute("userName");
		// /rengers/rengersList.jsp로 forward
		// rengersList.jsp에서는 해당 데이터를 출력
		req.getRequestDispatcher("/rangers/rangersList.jsp").forward(req, resp);
		
	}
	
}
