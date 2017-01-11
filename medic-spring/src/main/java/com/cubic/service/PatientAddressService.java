package com.cubic.service;

import java.util.List;

import com.cubic.entity.PatientAddressEntity;
import com.cubic.rest.vo.PatientAddress;

public interface PatientAddressService {

	List<PatientAddressEntity> createPatientAddress(final List<PatientAddress> patientAddress);

	void modifyPatientAddress(final PatientAddress patientAddress);

	List<PatientAddress> findPatientAddress(final List<PatientAddressEntity> patientAddress);

}
