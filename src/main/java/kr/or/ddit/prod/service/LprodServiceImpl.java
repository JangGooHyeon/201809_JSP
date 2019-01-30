package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.dao.ILprodDao;
import kr.or.ddit.prod.dao.LprodDaoImpl;
import kr.or.ddit.prod.model.LprodVo;
import kr.or.ddit.util.model.PageVo;

public class LprodServiceImpl implements ILprodService {

	private ILprodDao dao;

	public LprodServiceImpl() {
		dao = new LprodDaoImpl();
	}
	
	@Override
	public List<LprodVo> getAllLprod() {
		return dao.getAllLprod();
	}

	@Override
	public Map<String, Object> selectLprodPagingList(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("lprodList", dao.selectLprodPagingList(pageVo));
		resultMap.put("lprodCnt", dao.getLprodCnt());
		
		return resultMap;
	}

}
