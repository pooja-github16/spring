package com.elibrary.model;

public class IssuedBook {

	int id;
	String callno;
	int sid;
	String sname, mob, issueDate, returnStatus;

	public IssuedBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IssuedBook(int id, String callno, int sid, String sname, String mob, String issueDate, String returnStatus) {
		super();
		this.id = id;
		this.callno = callno;
		this.sid = sid;
		this.sname = sname;
		this.mob = mob;
		this.issueDate = issueDate;
		this.returnStatus = returnStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	@Override
	public String toString() {
		return "IssuedBook [id=" + id + ", callno=" + callno + ", sid=" + sid + ", sname=" + sname + ", mob=" + mob
				+ ", issueDate=" + issueDate + ", returnStatus=" + returnStatus + "]";
	}

}
