package kr.or.ddit.encrypt.kisa.seed;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* KISA_SEED_CBC_test.java
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
* 복호화가 가능한 seed 알고리즘 테스트
*
* </pre>
*/
public class KISA_SEED_CBC_test {

	private Logger logger = LoggerFactory.getLogger(KISA_SEED_CBC_test.class);
	/**
	 * Method : testEncypt
	 * 작성자 : goo84
	 * 변경이력 :
	 * Method 설명 : 암호화/복호화 테스트
	 */
	@Test
	public void testEncypt() {
		/***Given***/
		String plainText = "brown";
		
		
		/***When***/
		String encyptTest = KISA_SEED_CBC.Encrypt(plainText); //암호화 된 문자열을 리턴		
		logger.debug("encyptTest : {}", encyptTest);
		
		String decryptTest = KISA_SEED_CBC.Decrypt(encyptTest);
		logger.debug("decryptTest : {}", decryptTest);
		
		/***Then***/
		assertEquals(plainText, decryptTest);
		
	}

}
