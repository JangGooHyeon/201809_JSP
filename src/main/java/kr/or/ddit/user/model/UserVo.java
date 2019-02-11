package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserVo {
	private String userId;		//사용자 아이디
	private String pass;		//사용자 비밀번호
	private String userNm;		//사용자 이름
	private String alias; 		//별명
	private String addr1;		//주소
	private String addr2;		//상세주소
	private String zipcode;		//우편번호
	private Date   reg_dt;		//등록일시
	
	public String getReg_dt_fmt(){
		//reg_dt값을 yyyy-mm-dd형태로 포맷팅
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(reg_dt);
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
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", pass=" + pass + ", userNm="
				+ userNm + ", reg_dt=" + reg_dt + ", alias=" + alias
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode="
				+ zipcode + "]";
	}
	
}
