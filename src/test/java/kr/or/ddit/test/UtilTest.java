package kr.or.ddit.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.util.CookieUtil;

import org.junit.BeforeClass;
import org.junit.Test;

public class UtilTest {

	/**
	 * Method : test
	 * 작성자 : goo84
	 * 변경이력 :
	 * Method 설명 : cookie 문자열 파싱 테스트
	 */
	@Test
	public void testCookieStringParsing() {
		/***Given***/
		String cookieString = "userId=brown; rememberme=y; test=value";
		CookieUtil cookieUtil = new CookieUtil(cookieString);
		
		/***When***/
		String cookieValue1 = cookieUtil.getCookievalue("rememberme");
		String cookieValue2 = cookieUtil.getCookievalue("userId");
		String cookieValue3 = cookieUtil.getCookievalue("test");
		
		/***Then***/
		assertEquals("y", cookieValue1);
		assertEquals("brown", cookieValue2);
		assertEquals("value", cookieValue3);
		
	}

}
