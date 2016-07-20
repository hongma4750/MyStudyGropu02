package com.hongma.Member.BEAN;

public class MemberDTO {

	private String m_name;
	private String m_id;
	private String m_pw;
	private int m_age;
	private int m_admin;
	private String m_email;
	private int m_phone1;
	private int m_phone2;
	private int m_phone3;
	private String m_gender;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public int getM_age() {
		return m_age;
	}

	public void setM_age(int m_age) {
		this.m_age = m_age;
	}

	public int getM_admin() {
		return m_admin;
	}

	public void setM_admin(int m_admin) {
		this.m_admin = m_admin;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public int getM_phone1() {
		return m_phone1;
	}

	public void setM_phone1(int m_phone1) {
		this.m_phone1 = m_phone1;
	}

	public int getM_phone2() {
		return m_phone2;
	}

	public void setM_phone2(int m_phone2) {
		this.m_phone2 = m_phone2;
	}

	public int getM_phone3() {
		return m_phone3;
	}

	public void setM_phone3(int m_phone3) {
		this.m_phone3 = m_phone3;
	}

	

	public String getM_gender() {
		return m_gender;
	}

	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}

	@Override
	public String toString() {
		return "MemberDTO [m_name=" + m_name + ", m_id=" + m_id + ", m_pw=" + m_pw + ", m_age=" + m_age + ", m_admin="
				+ m_admin + ", m_email=" + m_email + ", m_phone1=" + m_phone1 + ", m_phone2=" + m_phone2 + ", m_phone3="
				+ m_phone3 + ", m_gender=" + m_gender + "]";
	}

	
	
}
