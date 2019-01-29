package kr.or.ddit.prod.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.LprodVo;

import org.junit.Before;
import org.junit.Test;

public class LprodServiceImplTest {

	@Test
	public void test() {
		ILprodService lprodService = new LprodServiceImpl();
		
		List<LprodVo> list = lprodService.getAllLprod();
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getLprod_id() + ", " + list.get(i).getLprod_gu());
		}
	}

}
