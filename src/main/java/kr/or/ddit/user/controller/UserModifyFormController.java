package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

@WebServlet("/userModifyForm")
public class UserModifyFormController extends HttpServlet {

	IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		
		UserVo vo = userService.selectUser(userId);
		request.setAttribute("userVo", vo);
		
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId  = request.getParameter("userId");
		String userNm  = request.getParameter("userNm");
		String alias   = request.getParameter("alias");
		String addr1   = request.getParameter("addr1");
		String addr2   = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		String pass	   = request.getParameter("pass");
		
		UserVo userVo = new UserVo();
		
		userVo.setUserId(userId);
		userVo.setUserNm(userNm);
		userVo.setAlias(alias);
		userVo.setAddr1(addr1);
		userVo.setAddr2(addr2);
		userVo.setZipcode(zipcode);
		userVo.setPass(pass);
		
		int updateCnt = userService.updateUser(userVo);
		
		if(updateCnt == 1){
			response.sendRedirect(request.getContextPath() + "/user?userId=" + userId);
		} else {
			doGet(request, response);
		}
		
	}

}
