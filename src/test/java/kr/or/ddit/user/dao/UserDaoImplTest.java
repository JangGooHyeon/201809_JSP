package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserDaoImplTest {
	
	private IUserDao dao;
	private SqlSession sqlSession;
	
	@Before
	public void setup(){
		dao = new UserDaoImpl();
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
	}
	
	@After
	public void testDown(){
		sqlSession.close();
	}
	
	
	@Test
	public void testGetAllUser() {
		/***Given***/
		
		/***When***/
		List<UserVo> list = dao.getAllUser(sqlSession);
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
		UserVo vo = dao.selectUser(sqlSession, "cony");
//		System.out.println(vo.getPass());
		
		/***Then***/
//		assertEquals(1, vo);
	}
	
	@Test
	public void testSelectUserPagingList(){
		/***Given***/
		PageVo vo = new PageVo(1, 10);
		
		/***When***/
		List<UserVo> list = dao.selectUserPagingList(sqlSession, vo);
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
		int cnt = dao.getUserCnt(sqlSession);
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
	
	@Test
	public void testInsertUser(){
		/***Given***/
		String userId = "goo7451";
		String userNm = "장구현";
		String alias = "짱구";
		String addr1 = "경북 김천시 시청2길 30";
		String addr2 = "금류아파트 2동 1402호";
		String zipcode = "39531";
		String pass = "testpass1234";
		
		/***When***/
		UserVo vo = new UserVo();
		vo.setUserId(userId);
		vo.setUserNm(userNm);
		vo.setAlias(alias);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setZipcode(zipcode);
		vo.setPass(pass);
		
		int cnt = dao.insertUser(sqlSession, vo);
		System.out.println(cnt);
		
		/***Then***/
		assertEquals(cnt, 1);
		
	}
	
	@Test
	public void testDeleteUser(){
		/***Given***/
		String userId = "goo7451";
		
		/***When***/
		int cnt = dao.deleteUser(sqlSession, userId);
		System.out.println(cnt);
		
		/***Then***/
		assertEquals(cnt, 1);
	}
	
	@Test
	public void testUpdateUser(){
		/***Given***/
		String userId = "1234";
		
		UserVo vo = dao.selectUser(sqlSession, userId);
		
		vo.setUserNm("qwe1");
		vo.setAlias("qwe2");
		vo.setAddr1("qwe3");
		vo.setAddr2("qwe4");
		vo.setZipcode("12345");
		vo.setPass("qwe123");
		
		/***When***/
		int updateCnt = dao.updateUser(sqlSession, vo);
		sqlSession.commit();
		
		System.out.println(updateCnt);
		
		/***Then***/
		assertEquals(updateCnt, 1);

	}

}
