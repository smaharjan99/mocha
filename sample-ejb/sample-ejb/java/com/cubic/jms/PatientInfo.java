package com.cubic.jms;

import java.io.Serializable;

public class PatientInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2561852924738614450L;

	private String firstName;
	private String lastName;

	public PatientInfo() {

	}

	public PatientInfo(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "PatientInfo [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
