package com.cubic.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.entity.PatientInfoEntity;

@Repository
public interface PatientInfoRepo extends CrudRepository<PatientInfoEntity, String> {

	@Query("select p from PatientInfoEntity p where UPPER(p.firstName) like UPPER(?1) OR UPPER(p.lastName) like UPPER(?2)")
	List<PatientInfoEntity> searchPatient(final String firstName, final String lastName);

	/*
	 * @Query(value = "select cust_seq.nextval from dual", nativeQuery = true)
	 * Long getPatienId();
	 */
}
