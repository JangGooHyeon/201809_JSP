package kr.or.ddit.util;

import java.util.ArrayList;
import java.util.List;

public class CookieUtil {

	private String[] cookieList;
	
	public CookieUtil(String cookieString) {
		cookieList = cookieString.split("; ");
	}

	/**
	 * Method : getCookievalue
	 * 작성자 : goo84
	 * 변경이력 :
	 * @param cookieName
	 * @return
	 * Method 설명 : 쿠키 이름에 해당하는 쿠기 값을 조회
	 */
	public String getCookievalue(String cookieName) {

		List<String> value = new ArrayList<String>();
		
		for(int i=0; i<cookieList.length; i++){
			if(cookieList[i].split("=")[0].equals(cookieName)){
				value.add(cookieList[i].split("=")[1]);
				return value.get(0);
			} 
		}
		return null;
	}

}
