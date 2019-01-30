package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;

public class UserServiceImplTest {

	IUserService userService;
	
	@Before
	public void setup(){
		userService = new UserServiceImpl();
	}
	
	@Test
	public void testGetAllUser() {
		/***Given***/
		IUserService service = new UserServiceImpl();
		
		/***When***/
		List<UserVo> list = service.getAllUser();
//		for(UserVo userVo : list){
//			System.out.println(userVo);
//		}

		/***Then***/
//		assertNotNull(list);
//		assertEquals(5, list.size());
	}
	
	@Test
	public void testSelectUser() {
		/***Given***/
		IUserService service = new UserServiceImpl();
		
		/***When***/
		UserVo vo = service.selectUser("cony");
//		System.out.println(vo.getPass());
		
		/***Then***/
//		assertEquals(1, list.size());
	}
	
	@Test
	public void testSelectUserPagingList(){
		/***Given***/
		PageVo vo = new PageVo(2, 10);
		
		/***When***/
		Map<String, Object> resultMap = userService.selectUserPagingList(vo);
		List<UserVo> list = (List<UserVo>)resultMap.get("userList");
		int cnt = (Integer) resultMap.get("userCnt");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("page 1 -> " + list.get(i).getUserId());
		}
		System.out.println("페이지당 건수 : " + list.size());
		System.out.println("전체 사용자 수 : " + cnt);
		/***Then***/
		//userList
		assertNotNull(list);
		assertEquals(10, list.size());
		
		//userCnt
		assertEquals(105, cnt);
	}
	
	
}
