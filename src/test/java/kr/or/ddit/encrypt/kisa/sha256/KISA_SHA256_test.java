package kr.or.ddit.encrypt.kisa.sha256;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* KISA_SHA256_test.java
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
*KISA_SHA256 hash 알고리즘 테스트
* </pre>
*/
public class KISA_SHA256_test {

	private Logger logger = LoggerFactory.getLogger(KISA_SHA256_test.class);
	
	/**
	 * Method : testEcrypt
	 * 작성자 : goo84
	 * 변경이력 :
	 * Method 설명 : 암호화 테스트
	 */
	@Test
	public void testEcrypt() {
		/***Given***/
		String plainText = "brown_test";
		
		/***When***/
		String encryptTest = KISA_SHA256.encrypt(plainText);
		logger.debug("encryptTest : {}", encryptTest);
		
		/***Then***/
		assertEquals("c164e18149487cb63aae08d72de9141f1898b08f13cc6e4252bdf8cfd420d5", encryptTest);
		
	}

}
