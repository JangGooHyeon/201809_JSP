package kr.or.ddit.prod.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.model.LprodVo;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;

public class LprodServiceImplTest {

	ILprodService lprodService;
	
	@Before
	public void setup(){
		lprodService = new LprodServiceImpl();
	}
	
	@Test
	public void test() {
		
		List<LprodVo> list = lprodService.getAllLprod();
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getLprod_id() + ", " + list.get(i).getLprod_gu());
		}
	}
	
	@Test
	public void testSelectLprodPagingList(){
		
		PageVo pageVo = new PageVo(1, 5);
		
		Map<String, Object> resultMap = lprodService.selectLprodPagingList(pageVo);
		List<LprodVo> list = (List<LprodVo>) resultMap.get("lprodList");
		int cnt = (Integer) resultMap.get("lprodCnt");
		
		for(int i=0; i<list.size(); i++){
			System.out.println("lprod_id : " + list.get(i).getLprod_id());
		}
		System.out.println("페이지 당 건수 : " + list.size());
		System.out.println("전체 제품리스트 수 : " + cnt);
		
		assertNotNull(list);
		
	}

}
