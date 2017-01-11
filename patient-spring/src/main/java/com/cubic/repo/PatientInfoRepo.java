package com.cubic.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cubic.entity.PatientInfoEntity;

public interface PatientInfoRepo extends CrudRepository<PatientInfoEntity, String> {

	@Query("select c from PatientInfoEntity c where UPPER(c.firstName) like UPPER(?1) AND UPPER(c.lastName) like UPPER(?2)")
	List<PatientInfoEntity> searchPatientInfo(final String firstName, final String lastName);

	@Query(value = "select pat_seq.nextval from dual", nativeQuery = true)
	Long getPatienId();
}
