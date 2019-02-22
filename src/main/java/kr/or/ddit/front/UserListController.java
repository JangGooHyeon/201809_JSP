package kr.or.ddit.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

/**
* UserListController.java
*
* @author goo84
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* goo84 최초 생성
* 사용자 전체 리스트 조회 컨트롤러
* </pre>
*/
public class UserListController implements CommonController{

	@Override
	public String process(HttpServletRequest request,HttpServletResponse response) {

		//사용자 리스트 조회
		IUserService service = new UserServiceImpl();
		List<UserVo> userList = service.getAllUser();
		
		//사용자 리스트 정보 속성 설정
		request.setAttribute("userList", userList);
		
		//사용자 리스트 정보를 출력할 화면 정보 리턴
		//jsp : forward, redirect --> spring : json응답, jsp응답, tiles응답 () 
		return "forward:/front/userList.jsp";
	}
	
}
