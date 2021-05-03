package com.elibrary.model;

public class ReturnBook {
	String callno;
	int sid;
	public ReturnBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReturnBook(String callno, int sid) {
		super();
		this.callno = callno;
		this.sid = sid;
	}
	public String getCallno() {
		return callno;
	}
	public void setCallno(String callno) {
		this.callno = callno;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "ReturnBook [callno=" + callno + ", sid=" + sid + "]";
	}
	
}
