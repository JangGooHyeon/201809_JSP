package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

import org.junit.Test;

public class ProdServiceImplTest {

	@Test
	public void test() {
		IProdService prodService = new ProdServiceImpl();
		
		List<ProdVo> list = (List<ProdVo>)prodService.selectLprod("P101");
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getProd_id());
		}
		
	}

}
