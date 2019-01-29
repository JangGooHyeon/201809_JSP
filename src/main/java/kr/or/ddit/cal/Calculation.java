package kr.or.ddit.cal;

import kr.or.ddit.servlet.sumCalculationServlet;

/**
* Calculation.java
*
* @author goo84
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* goo84 최초 생성
*
* </pre>
*/
public class Calculation {
	
	public static void main(String[] args) {
		//sum메소드 테스트
		Calculation cal = new Calculation();
		
		int resultSum = cal.sum(10, 5);
		if(resultSum == 15){
			System.out.println("성공쓰");
		} else {
			System.out.println("실패 : " + resultSum);
		}
		
		int resultMul = cal.mul(10, 5);
		if(resultMul == 50){
			System.out.println("성공쓰");
		} else {
			System.out.println("실패 : "+ resultMul);
		}
	}
	
	/**
	 * Method : sum
	 * 작성자 : goo84
	 * 변경이력 :
	 * @param param1
	 * @param param2
	 * @return
	 * Method 설명 : 두 개의 인수를 더해주는 메소드
	 */
	public int sum(int param1, int param2) {
		return param1 + param2;
	}
	
	public int mul(int param1, int param2) {
		return param1 * param2;
	}
	
	public int div(int param1, int param2) {
		if(param2 == 0){
			return 0;
		} else {
			return param1 / param2;
		}
	}

	public int sub(int i, int j) {
		return i - j;
	}

}
