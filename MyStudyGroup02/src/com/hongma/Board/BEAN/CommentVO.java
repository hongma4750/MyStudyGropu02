package com.hongma.Board.BEAN;

import java.sql.Timestamp;

public class CommentVO {

	private int com_seq;
	private int b_num;
	private String m_id;
	private String com_content;
	private Timestamp com_writedate;
	private int com_ref;
	private int com_step;
	private int com_depth;
	private int com_parent;
	private int com_del;
	
	public CommentVO() {
		// TODO Auto-generated constructor stub
	}

	public int getCom_seq() {
		return com_seq;
	}

	public void setCom_seq(int com_seq) {
		this.com_seq = com_seq;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public String getCom_content() {
		return com_content;
	}

	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}

	public Timestamp getCom_writedate() {
		return com_writedate;
	}

	public void setCom_writedate(Timestamp com_writedate) {
		this.com_writedate = com_writedate;
	}

	public int getCom_ref() {
		return com_ref;
	}

	public void setCom_ref(int com_ref) {
		this.com_ref = com_ref;
	}

	public int getCom_step() {
		return com_step;
	}

	public void setCom_step(int com_step) {
		this.com_step = com_step;
	}

	public int getCom_depth() {
		return com_depth;
	}

	public void setCom_depth(int com_depth) {
		this.com_depth = com_depth;
	}

	public int getCom_parent() {
		return com_parent;
	}

	public void setCom_parent(int com_parent) {
		this.com_parent = com_parent;
	}

	public int getCom_del() {
		return com_del;
	}

	public void setCom_del(int com_del) {
		this.com_del = com_del;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	@Override
	public String toString() {
		return "CommentVO [com_seq=" + com_seq + ", b_num=" + b_num + ", m_id=" + m_id + ", com_content=" + com_content
				+ ", com_writedate=" + com_writedate + ", com_ref=" + com_ref + ", com_step=" + com_step
				+ ", com_depth=" + com_depth + ", com_parent=" + com_parent + ", com_del=" + com_del + "]";
	}

	
	
	
}
