package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.ILprodDao;
import kr.or.ddit.prod.dao.LprodDaoImpl;
import kr.or.ddit.prod.model.LprodVo;

public class LprodServiceImpl implements ILprodService {

	private ILprodDao dao;

	public LprodServiceImpl() {
		dao = new LprodDaoImpl();
	}
	
	@Override
	public List<LprodVo> getAllLprod() {
		return dao.getAllLprod();
	}

}
