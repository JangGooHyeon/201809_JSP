package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;

public class UserDaoImplTest {
	
	IUserDao dao = new UserDaoImpl();
	
	@Before
	public void setup(){
		dao = new UserDaoImpl();
	}
	
	@Test
	public void testGetAllUser() {
		/***Given***/
		IUserDao dao = new UserDaoImpl();
		
		/***When***/
		List<UserVo> list = dao.getAllUser();
//		for(UserVo userVo : list){
//			System.out.println(userVo);
//		}

		/***Then***/
		assertNotNull(list);
		assertEquals(105, list.size());
		
	}
	
	@Test
	public void testSelectUser() {
		/***Given***/
		IUserDao dao = new UserDaoImpl();
		
		/***When***/
		UserVo vo = dao.selectUser("cony");
//		System.out.println(vo.getPass());
		
		/***Then***/
//		assertEquals(1, vo);
	}
	
	@Test
	public void testSelectUserPagingList(){
		/***Given***/
		PageVo vo = new PageVo(1, 10);
		
		/***When***/
		List<UserVo> list = dao.selectUserPagingList(vo);
		for(int i=0; i<list.size(); i++) {
			System.out.println("page 1 -> " + list.get(i).getUserId());
		}
		System.out.println("페이지당 건수 : " + list.size());
		/***Then***/
		assertNotNull(list);
		assertEquals(10, list.size());
	}
	
	/**
	 * Method : testGetUserCnt
	 * 작성자 : goo84
	 * 변경이력 :
	 * Method 설명 : 전체 사용자 수 조회 테스트
	 */
	@Test
	public void TestGetUserCnt(){
		/***Given***/
		
		/***When***/
		int cnt = dao.getUserCnt();
		System.out.println("전체 사용자 수 : " + cnt);
		
		/***Then***/
		assertNotNull(cnt);
		assertEquals(105, cnt);
	}
	
	@Test
	public void testPagination(){
		/***Given***/
		int userCnt  = 105;
		int pageSize = 10;
		
		/***When***/
		//ceil, floor
		int lastPage = (int)Math.ceil(userCnt/pageSize) + (int)Math.ceil(userCnt%pageSize > 0 ? 1 : 0);
		System.out.println(lastPage);
		
		/***Then***/
		assertEquals(11, lastPage);
	}

	@Test
	public void testPagination2(){
		/***Given***/
		int userCnt  = 110;
		int pageSize = 10;
		
		/***When***/
		//ceil, floor
		int lastPage = (int)Math.ceil(userCnt/pageSize) + (int)Math.ceil(userCnt%pageSize > 0 ? 1 : 0);
		System.out.println(lastPage);
		
		/***Then***/
		assertEquals(11, lastPage);
	}

}
