package com.cubic.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloEjb {

	String sayHello();

}
