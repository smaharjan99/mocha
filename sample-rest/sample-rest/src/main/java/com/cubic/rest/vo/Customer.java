package com.cubic.rest.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	private String firstName;
	private String lastName;
	private String desc;
	private String id;

	public String getFirstName() {
		return firstName;
	}

	public Customer setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Customer setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public Customer setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public String getId() {
		return id;
	}

	public Customer setId(String id) {
		this.id = id;
		return this;
	}

}
