package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

import org.junit.Test;

public class UserDaoImplTest {
	
	@Test
	public void testGetAllUser() {
		/***Given***/
		IUserDao dao = new UserDaoImpl();
		
		/***When***/
		List<UserVo> list = dao.getAllUser();
		for(UserVo userVo : list){
			System.out.println(userVo);
		}

		/***Then***/
//		assertNotNull(list);
		assertEquals(5, list.size());
		
	}
	
	@Test
	public void testSelectUser() {
		/***Given***/
		IUserDao dao = new UserDaoImpl();
		
		/***When***/
		UserVo vo = dao.selectUser("cony");
		System.out.println(vo.getPass());
		
		/***Then***/
		assertEquals(1, vo);
	}

}
