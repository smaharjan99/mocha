package com.cubic.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.entity.CustomerEntity;

@Repository
public interface CustomerRepo extends CrudRepository<CustomerEntity, Long> {

	@Query("select c from CustomerEntity c where UPPER(c.firstName) like UPPER(?1) OR UPPER(c.lastName) like UPPER(?2)")
	List<CustomerEntity> searchCustomer(final String firstName, final String lastName);

	@Query("select count(*) from CustomerEntity c where UPPER(c.firstName) like UPPER(?1) OR UPPER(c.lastName) like UPPER(?2)")
	Long countCustomer(final String firstName, final String lastName);

}
