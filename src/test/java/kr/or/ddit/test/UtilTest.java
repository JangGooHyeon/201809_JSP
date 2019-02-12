package kr.or.ddit.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.util.CookieUtil;
import kr.or.ddit.util.PartUtil;

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

	/**
	 * Method : testGetFileNameFromPart
	 * 작성자 : goo84
	 * 변경이력 :
	 * Method 설명 : part의 Content-Disposition 헤더로 부터 filename을 가져온다.
	 */
	@Test
	public void testGetFileNameFromPart(){
		/***Given***/
		String contentDisposition = "form-data; name=\"uploadFile\"; filename=\"cogi.jpg\"";
		String contentDisposition2 = "form-data; name=\"uploadFile\"; filename=\"cogis.jpg\"";
		
		/***When***/
		String fileName = PartUtil.getFileNameFromPart(contentDisposition);
		String fileName2 = PartUtil.getFileNameFromPart(contentDisposition2);
		
		/***Then***/
		assertEquals("cogi.jpg", fileName);
		assertEquals("cogis.jpg", fileName2);

	}
	
}
