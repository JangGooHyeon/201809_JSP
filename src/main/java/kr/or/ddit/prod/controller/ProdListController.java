package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;

@WebServlet("/prodList")
public class ProdListController extends HttpServlet {

	IProdService prodService;
	
	@Override
	public void init() throws ServletException {
		prodService = new ProdServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prod_lgu = request.getParameter("lprodgu");
		List<ProdVo> list = prodService.selectLprod(prod_lgu);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/prod/prodList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
