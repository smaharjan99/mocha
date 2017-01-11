package com.cubic.test;

import com.cubic.spring.DBParameter;
import com.cubic.spring.SpringFactory;

public class SpringTestProperties {

	public static void main(String[] args) {

		DBParameter ps = SpringFactory.getInstance().getBean(DBParameter.class);

		System.out.println("url - " + ps.getUrl());
		System.out.println("username - " + ps.getUsername());
		System.out.println("password - " + ps.getPassword());

	}

}
