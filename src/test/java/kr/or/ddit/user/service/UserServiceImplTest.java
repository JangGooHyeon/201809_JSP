package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;

public class UserServiceImplTest {

	@Test
	public void testGetAllUser() {
		/***Given***/
		IUserService service = new UserServiceImpl();
		
		/***When***/
		List<UserVo> list = service.getAllUser();
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
		IUserService service = new UserServiceImpl();
		
		/***When***/
		UserVo vo = service.selectUser("cony");
		System.out.println(vo.getPass());
		
		/***Then***/
//		assertEquals(1, list.size());
		
	}
}
