package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.LprodVo;
import kr.or.ddit.prod.service.ILprodService;
import kr.or.ddit.prod.service.LprodServiceImpl;

@WebServlet("/lprodList")
public class LprodListController extends HttpServlet {
	
	private ILprodService lprodService;
	
	@Override
	public void init() throws ServletException {
		lprodService = new LprodServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LprodVo> lprodList = lprodService.getAllLprod();
		
		request.setAttribute("lprodList", lprodList);
		request.getRequestDispatcher("/prod/lprodList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
