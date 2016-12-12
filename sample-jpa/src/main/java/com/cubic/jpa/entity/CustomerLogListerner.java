package com.cubic.jpa.entity;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class CustomerLogListerner {

	@PrePersist
	public void beforeCreate(final CustomerEntity entity) {
		entity.setSsn("000-00-000");
		System.out.println("Before Create - " + entity);
	}

	@PostPersist
	public void afterCreate(final CustomerEntity entity) {
		System.out.println("After Create - " + entity);
	}

	@PreUpdate
	public void beforeUpdate(final CustomerEntity entity) {
		System.out.println("Before Create - " + entity);
		entity.setSsn("111-11-2121");

	}

	@PostUpdate
	public void afterUpdate(final CustomerEntity entity) {
		System.out.println("After Update - " + entity);

	}

}
