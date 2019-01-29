package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserVo {
	private String userId;		//사용자 아이디
	private String pass;		//사용자 비밀번호
	private String userNm;		//사용자 이름
	private Date reg_dt;		//등록일시
	
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public String getReg_dt_fmt(){
		//reg_dt값을 yyyy-mm-dd형태로 포맷팅
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(reg_dt);
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", pass=" + pass + ", userNm="
				+ userNm + ", reg_dt=" + reg_dt + "]";
	}
	
}
