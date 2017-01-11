package com.cubic.ejb.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.cubic.ejb.HelloEjb;

public class HelloEjbClient {
	public static void main(String[] args) throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

		InitialContext ctx = new InitialContext(props);
		HelloEjb instance = (HelloEjb) ctx.lookup(HelloEjb.class.getName());
		System.out.println(instance.getClass().getName());
		System.out.println(instance.sayHello());
	}

}
