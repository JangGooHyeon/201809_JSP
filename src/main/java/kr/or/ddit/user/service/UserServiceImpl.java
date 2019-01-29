package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVo;

public class UserServiceImpl implements IUserService {

	private IUserDao dao;

	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}

	/**
	 * Method : getAllUser
	 * 작성자 : goo84
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 사용자 정보 조회
	 */
	@Override
	public List<UserVo> getAllUser() {
		return dao.getAllUser();
	}

	/**
	 * Method : selectUser
	 * 작성자 : goo84
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 특정 사용자 정보 조회
	 */
	@Override
	public UserVo selectUser(String userId) {
		return dao.selectUser(userId);
	}
	
}
