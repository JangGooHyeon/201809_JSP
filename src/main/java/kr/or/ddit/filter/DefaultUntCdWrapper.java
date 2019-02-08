package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DefaultUntCdWrapper extends HttpServletRequestWrapper {

	private Map<String, String[]> paramMap;
	
	public DefaultUntCdWrapper(HttpServletRequest request) {
		super(request);
		
		//원본 parameter + 추가하고자 하는 parameter를 parameterMap에 추가

		//원본 parameter 추가
		paramMap = new HashMap<String, String[]>(request.getParameterMap());
		
		
		//추가 하고자 하는 parameter(unt_cd)
		//unt_cd parameter가 존재하면 그대로 사용
		//unt_cd parameter가 존재하지 않으면 unt_cd parameter에 ddit라는 값을 추가
		String unt_cd = request.getParameter("unt_cd");
		if(unt_cd == null){
//			System.out.println("ddit");
			paramMap.put("unt_cd", new String[]{"ddit"});
		}
		
	}
	//parameterMap에 대해 재정의(request.getParameterMap())

	@Override
	public String getParameter(String name) {
		String[] values = paramMap.get(name);
		return values == null ? null : values[0];
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return paramMap;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(paramMap.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return paramMap.get(name);
	}
	
	//parameter 관련 메소드(4개)에 대해 재정의
	
	
	
}
