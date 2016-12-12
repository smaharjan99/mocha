package com.cubic.jpa.entity;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class CustomerAuditListerner {

	@PrePersist
	public void beforeCreate(final CustomerEntity entity) {
		System.out.println("Inside Audit Before Create -" + entity);
		entity.setLastName("Wassah!!");
	}

	@PostPersist
	public void afterCreate(final CustomerEntity entity) {
		System.out.println("After Audit - " + entity);
	}

}
