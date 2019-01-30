package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.LprodVo;
import kr.or.ddit.util.model.PageVo;

public interface ILprodDao {
	List<LprodVo> getAllLprod();
	
	List<LprodVo> selectLprodPagingList(PageVo pageVo);
	
	int getLprodCnt();
}
