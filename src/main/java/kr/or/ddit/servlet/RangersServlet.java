package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.rangers.service.RangersService;

@WebServlet("/rengersList")
public class RangersServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// service객체를 이용하여 rengersList를 조회
		RangersService rangersService = new RangersService();
		List<String> rangersList = rangersService.getAll();
		
		// 해당 데이터를 request 영역에 설정
		req.setAttribute("rangersList", rangersList);
		
		// /rengers/rengersList.jsp로 forward
		// rengersList.jsp에서는 해당 데이터를 출력
		req.getRequestDispatcher("/rangers/rangersList.jsp").forward(req, resp);
		
	}
	
}
