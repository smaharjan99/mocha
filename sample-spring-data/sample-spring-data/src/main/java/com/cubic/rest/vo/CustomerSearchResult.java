package com.cubic.rest.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerSearchResult {
	private List<Customer> customers = null;

	public CustomerSearchResult() {

	}

	public CustomerSearchResult(final List<Customer> customers) {
		this.customers = customers;
		/* (customers ==null?new ArrayList<Customer>():customers) */
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}
