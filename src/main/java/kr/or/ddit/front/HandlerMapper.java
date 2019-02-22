package kr.or.ddit.front;

import java.util.HashMap;
import java.util.Map;

/**
* HandlerMapper.java
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
*uri 정보를 바탕으로 해당 요청을 처리해 줄 컨트롤러를 생성, 반환해주는 객체
*
* </pre>
*/
public class HandlerMapper {
	
	//Map<url문자열, url요청을 처리할 컨트롤러 클래스명>
	private Map<String, String> urlControllerMap;
	
	public HandlerMapper(){
		//DB 혹은 properties에서 데이터를 조회해야 한다.
		// -> 테스트 목적으로 직접 넣음
		urlControllerMap = new HashMap<String, String>();
		
		urlControllerMap.put("/userList.do", "kr.or.ddit.front.UserListController");
		urlControllerMap.put("/rangersList.do", "kr.or.ddit.front.RangersListController");
	}
	
	/**
	 * Method : getController
	 * 작성자 : goo84
	 * 변경이력 :
	 * @param url
	 * @return
	 * Method 설명 : uri요청을 처리해 줄 pojo controller를 리턴
	 */
	public CommonController getController(String url){
		// *** pojo class :  servlet을 상속받지 않는 컨트롤러
		
		String classInfo = urlControllerMap.get(url);
		
		CommonController controller = null;
		//인스턴스를 생성하는 방법
		//1. Integer i  = new Integer();  --> 객체를 생성하기 위해 [new] 연산자를 사용
		//   String msg = "msg"; 		  --> 문자열을 담는 String객체의 경우는 예외적으로 사용가능
		//2. class 정보를 이용하여 객체를 생성 : 문자열  --> 클래스를 생성
		
		//UserVo userVo = new UserVo();
		try {
			Class clazz = Class.forName(classInfo);
			//newInstance() 메소드를 사용하여 인스턴스를 생성할 수 있다.
			// 작업 진행 ------------------------------------
			clazz.newInstance();
			
			controller = (CommonController)clazz.newInstance();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return controller;
	}
	
	
	
}
