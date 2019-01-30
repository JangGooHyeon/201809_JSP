package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.prod.model.LprodVo;
import kr.or.ddit.util.model.PageVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class LprodDaoImpl implements ILprodDao {

	@Override
	public List<LprodVo> getAllLprod() {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<LprodVo> lprodList = sqlSession.selectList("lprod.getAllLprod");
		sqlSession.close();
		
		return lprodList;
	}

	@Override
	public List<LprodVo> selectLprodPagingList(PageVo pageVo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<LprodVo> lprodList = sqlSession.selectList("lprod.selectLprodPagingList", pageVo);
		sqlSession.close();
		
		return lprodList;
	}

	@Override
	public int getLprodCnt() {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int lprodCnt = sqlSession.selectOne("lprod.getLprodCnt");
		sqlSession.close();
		
		return lprodCnt;
	}
}
