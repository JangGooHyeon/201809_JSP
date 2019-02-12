package kr.or.ddit.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
	
	//1. logger 선언
//	private Logger logger = LoggerFactory.getLogger(Class);
	private Logger logger = LoggerFactory.getLogger(LogbackTest.class);
	
//	private Logger logger = LoggerFactory.getLogger("kr.or.ddit.util.log.LogbackTest");
//	<logger name="kr.or.ddit" level="DEBUG">
//	private Logger logger = LoggerFactory.getLogger(String);
	
	
	public LogbackTest() {
		System.out.println("test");
		
		logger.trace("trace " + "test");
		logger.debug("debug " + "debug");
		logger.info("info " + "info");
		logger.warn("warn " + "warn");
		
		// ==============================================
		
		logger.error("error " + "error");
		logger.error("error {}, {}, {}", "test1", "test2", "test3");
	}
	
	public static void main(String[] args) {
		
		LogbackTest logbackTest = new LogbackTest();
		
		
	}

}
