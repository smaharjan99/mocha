package com.cubic.ejb;

import java.io.Serializable;

public class PatientInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1827168026326851610L;

	private String fname;
	private String lname;

	public PatientInfo() {

		// TODO Auto-generated constructor stub
	}

	public PatientInfo(String fname, String lname) {

		this.fname = fname;
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "PatientInfo [fname=" + fname + ", lname=" + lname + "]";
	}

}
