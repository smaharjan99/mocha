package com.cubic.spring;

public class EmailNotification implements NotificationService {

	@Override
	public void notifyCustomer(ProductVo vo) {
		System.out.println("Email sent to Customer");

	}

}
