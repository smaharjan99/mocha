package com.cubic.ejb;

import javax.ejb.Stateless;

@Stateless
public class MySampleEjb {

	public String getName() {
		return "From Sample EJB";
	}
}
