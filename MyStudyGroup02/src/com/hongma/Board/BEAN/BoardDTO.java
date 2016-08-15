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
	private String m_id;
	private int b_ref;
	private int b_step;
	private int b_depth;
	private int b_parent;
	private int b_del;
	
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

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getB_ref() {
		return b_ref;
	}

	public void setB_ref(int b_ref) {
		this.b_ref = b_ref;
	}

	public int getB_step() {
		return b_step;
	}

	public void setB_step(int b_step) {
		this.b_step = b_step;
	}

	public int getB_depth() {
		return b_depth;
	}

	public void setB_depth(int b_depth) {
		this.b_depth = b_depth;
	}

	public int getB_parent() {
		return b_parent;
	}

	public void setB_parent(int b_parent) {
		this.b_parent = b_parent;
	}

	public int getB_del() {
		return b_del;
	}

	public void setB_del(int b_del) {
		this.b_del = b_del;
	}

	@Override
	public String toString() {
		return "BoardDTO [b_num=" + b_num + ", m_name=" + m_name + ", m_email=" + m_email + ", b_pass=" + b_pass
				+ ", b_title=" + b_title + ", b_content=" + b_content + ", b_readcount=" + b_readcount
				+ ", b_writedate=" + b_writedate + ", m_id=" + m_id + ", b_ref=" + b_ref + ", b_step=" + b_step
				+ ", b_depth=" + b_depth + ", b_parent=" + b_parent + ", b_del=" + b_del + ", getB_num()=" + getB_num()
				+ ", getM_name()=" + getM_name() + ", getM_email()=" + getM_email() + ", getB_pass()=" + getB_pass()
				+ ", getB_title()=" + getB_title() + ", getB_content()=" + getB_content() + ", getB_readcount()="
				+ getB_readcount() + ", getB_writedate()=" + getB_writedate() + ", getM_id()=" + getM_id()
				+ ", getB_ref()=" + getB_ref() + ", getB_step()=" + getB_step() + ", getB_depth()=" + getB_depth()
				+ ", getB_parent()=" + getB_parent() + ", getB_del()=" + getB_del() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	

	
	
}
