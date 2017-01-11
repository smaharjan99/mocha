package com.cubic.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.entity.PatientAllergyEntity;

@Repository
public interface PatientAllergyRepo extends CrudRepository<PatientAllergyEntity, String> {

}
