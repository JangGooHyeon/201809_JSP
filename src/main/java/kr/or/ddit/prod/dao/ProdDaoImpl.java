package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.model.UserVo;

public class ProdDaoImpl implements IProdDao {

	@Override
	public List<ProdVo> selectLprod(String prod_lgu) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<ProdVo> selectLprod = sqlSession.selectList("prod.selectLprod", prod_lgu); 
		sqlSession.close();
		
		return selectLprod;
	}

}
