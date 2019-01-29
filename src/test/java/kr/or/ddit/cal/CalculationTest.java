package kr.or.ddit.cal;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculationTest {

	private Calculation cal;

	//@Before와 @After 어노테이션은 @Test 어노테이션이 적용된 테스트 메소드를 실행하기 전에 매번 실행된다.
	@Before
	public void setup(){
		System.out.println("setup");
		cal = new Calculation();
	}
	
	@After
	public void tearDown(){
		System.out.println("tearDown");
	}
	
	// @Test 어노테이션이 붙은 메소드를 테스트 메소드라고 한다.
	// 테스트 메소드 명명규칙 : test + 테스트 대상 메소드 
	// ex) sum 메소드 --> testSum
	// 성공 : 1. 테스트 메소드가 예외 발생 없이 정상적으로 실행된 경우 
	//		2. assert관련 메소드가 있을 경우 assert구문을 정상적으로 통과
	@Test
	public void testSum() {
		//sum 메소드
		int resultSum = cal.sum(10, 5);
		
		//예상되는 결과
		assertEquals(15, resultSum);
	}

	@Test
	public void testSum_scenario2() {
		//sum 메소드
		int resultSum = cal.sum(-1, -6);
		
		//예상되는 결과
		assertEquals(-7, resultSum);
	}
	
	@Test
	public void testMul(){
		/***Given***/

		/***When***/
		int resultMul = cal.mul(10, 5);

		/***Then***/
		assertEquals(50, resultMul);
	}
	
	@Test
	public void testDiv(){
		/***Given***/
		
		/***When***/
		int resultDiv = cal.div(10, 5);
		
		/***Then***/
		assertEquals(2, resultDiv);
	}

	@Test
	public void testDiv_divZero(){
		/***Given***/
		
		/***When***/
		int resultDiv = cal.div(10, 0);
		
		/***Then***/
		assertEquals(0, resultDiv);
	}

	@Test
	public void testEfficentlySum(){
		int sum = 0;
		int int_start = 1;
		int int_end = 10;
		sum = (int_end * (int_end+1))/2 - ((int_start*(int_start+1))/2- int_start);
		
		assertEquals(55, sum);
	}
	
	@Test
	public void  testSub() {
		/***Given***/
		
		
		/***When***/
		int result = cal.sub(10, 5);
		
		/***Then***/
		assertEquals(5, result);
	}
	// TDD : Test Driven Development
	
}
