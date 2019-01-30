package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

public class ProdServiceImpl implements IProdService {
	
	private IProdDao dao;

	public ProdServiceImpl() {
		dao = new ProdDaoImpl();
	}

	@Override
	public List<ProdVo> selectLprod(String prod_lgu) {
		return dao.selectLprod(prod_lgu);
	}

}
