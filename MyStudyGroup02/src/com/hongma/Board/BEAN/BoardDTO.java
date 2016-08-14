package com.hongma.Board.BEAN;

import java.sql.Timestamp;

public class BoardDTO {
 
	private int b_num;
	private String m_name;
	private String m_email;
	private String b_pass;
	private String b_title;
	private String b_content;
	private int b_readcount;
	private Timestamp b_writedate;
	
	public BoardDTO() {
	
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getB_pass() {
		return b_pass;
	}

	public void setB_pass(String b_pass) {
		this.b_pass = b_pass;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public int getB_readcount() {
		return b_readcount;
	}

	public void setB_readcount(int b_readcount) {
		this.b_readcount = b_readcount;
	}

	public Timestamp getB_writedate() {
		return b_writedate;
	}

	public void setB_writedate(Timestamp b_writedate) {
		this.b_writedate = b_writedate;
	}

	@Override
	public String toString() {
		return "BoardDTO [b_num=" + b_num + ", m_name=" + m_name + ", m_email=" + m_email + ", b_pass=" + b_pass
				+ ", b_title=" + b_title + ", b_content=" + b_content + ", b_readcount=" + b_readcount
				+ ", b_writedate=" + b_writedate + "]";
	}

	
	
}
