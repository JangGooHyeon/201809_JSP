package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
	
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	/**
	 * Method : doGet
	 * 작성자 : goo84
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 사용자 등록 버튼
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("user/userForm.jsp").forward(request, response);
	}

	/**
	 * Method : doPost
	 * 작성자 : goo84
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 사용자 정보 등록
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userId  = request.getParameter("userId");
		String userNm  = request.getParameter("userNm");
		String alias   = request.getParameter("alias");
		String addr1   = request.getParameter("addr1");
		String addr2   = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		String pass	   = request.getParameter("pass");

		UserVo vo = userService.selectUser(userId);
		
		//1. 사용자 아이디 중복체크
		
		//2-1. 중복체크 통과 : 사용자 정보를 DB에 입력
		if(vo == null){
			UserVo userVo = new UserVo();
			
			userVo.setUserId(userId);
			userVo.setUserNm(userNm);
			userVo.setAlias(alias);
			userVo.setAddr1(addr1);
			userVo.setAddr2(addr2);
			userVo.setZipcode(zipcode);
			userVo.setPass(pass);
			
			int insertCnt = userService.insertUser(userVo);
			
			//2-1-1. 사용자 페이징 리스트 1페이지로 이동(정상입력 성공)
			if(insertCnt == 1){
				request.getSession().setAttribute("msg", "정상적으로 등록되었습니다.");
				response.sendRedirect(request.getContextPath()+"/userPagingList");
			} else { //(정상입력 실패)
				doGet(request, response);
			}
			
			
		//2-2. 중복체크 통과 실패 : 사용자 등록페이지로 이동
		} else {
			//forward 시에는 최초 요청한 method를 변경 불가하다.
			//post --> post
			//request.getRequestDispatcher(/userForm.jsp).forward(request, response);
			//request.getRequestDispatcher(//user/userForm.jsp).forward(request, response);
			request.setAttribute("msg", "이미 존재하는 아이디 입니다.");
			doGet(request, response);
		}
		
		
	}

	
	
}
