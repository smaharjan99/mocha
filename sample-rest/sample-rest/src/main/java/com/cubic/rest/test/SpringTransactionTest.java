package com.cubic.rest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cubic.service.CustomerTransaction;

public class SpringTransactionTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerTransaction ct = context.getBean("pt", CustomerTransaction.class);
		ct.createCustomer();

	}

}
