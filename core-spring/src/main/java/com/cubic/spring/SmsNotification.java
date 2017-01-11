package com.cubic.spring;

public class SmsNotification implements NotificationService {

	@Override
	public void notifyCustomer(ProductVo vo) {
		System.out.println("SMS sent to Customer");

	}

}
