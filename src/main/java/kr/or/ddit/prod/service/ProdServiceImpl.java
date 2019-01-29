package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.model.ProdVo;

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
