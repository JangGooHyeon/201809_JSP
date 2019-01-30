package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.LprodVo;
import kr.or.ddit.prod.service.ILprodService;
import kr.or.ddit.prod.service.LprodServiceImpl;
import kr.or.ddit.util.model.PageVo;

/**
 * Servlet implementation class LprodPagingListController
 */
@WebServlet("/lprodPagingList")
public class LprodPagingListController extends HttpServlet {
	
	private ILprodService lprodService;
	
	@Override
	public void init() throws ServletException {
		lprodService = new LprodServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		
		int page 	 = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 5 : Integer.parseInt(pageSizeStr);
		
		PageVo pageVo = new PageVo(page, pageSize);
		
		Map<String, Object> resultMap = lprodService.selectLprodPagingList(pageVo);
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
		int lprodCnt = (Integer) resultMap.get("lprodCnt");
		
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("lprodCnt", lprodCnt);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/prod/lprodPagingList.jsp").forward(request, response);
		
	}

}
