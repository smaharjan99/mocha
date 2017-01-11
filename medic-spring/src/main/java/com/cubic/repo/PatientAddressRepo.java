package com.cubic.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.entity.PatientAddressEntity;

@Repository
public interface PatientAddressRepo extends CrudRepository<PatientAddressEntity, String> {

}
