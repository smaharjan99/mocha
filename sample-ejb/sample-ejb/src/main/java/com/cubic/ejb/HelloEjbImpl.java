package com.cubic.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class HelloEjbImpl implements HelloEjb {

	@EJB
	private MySampleEjb sampleEjb;

	public String sayHello() {
		return sampleEjb.getName();
	}

}
