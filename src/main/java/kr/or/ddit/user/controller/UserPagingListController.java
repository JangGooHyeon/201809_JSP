package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.model.PageVo;

@WebServlet("/userPagingList")
public class UserPagingListController extends HttpServlet {
	
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pageSize에 해당하는 parameter받기 => pageVo에 담기
		//단, parameter가 없을 경우 page : 1, pagesize : 10
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		
		int page 	 = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 10 : Integer.parseInt(pageSizeStr);
		
		PageVo pageVo = new PageVo(page, pageSize);
		
		//UserService객체를 이용하여 userPagingList 조회
		Map<String, Object> resultMap = userService.selectUserPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int userCnt = (Integer) resultMap.get("userCnt");
		
		//request갹체에 조회된 결과를 속성으로 섫정
		request.setAttribute("userList", userList);		//전체 사용자 리스트
		request.setAttribute("userCnt", userCnt);		//전체 사용자 수
		request.setAttribute("pageSize", pageSize);		//조회 건수
		request.setAttribute("page", page);				//페이지
		
		//userPagingList를 화면으로 출력할 jsp로 위임(forward)
		request.getRequestDispatcher("/user/userPagingList.jsp").forward(request, response);
		
	}

}
