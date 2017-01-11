package com.cubic.service;

import java.util.List;

import com.cubic.entity.PatientAllergyEntity;
import com.cubic.rest.vo.PatientAllergy;

public interface PatientAllergyService {

	List<PatientAllergyEntity> createPatientAllergy(final List<PatientAllergy> patientAllergy);

	void modifyPatientAllergy(final PatientAllergy patientAllergy);

	List<PatientAllergy> findPatientAllergy(final List<PatientAllergyEntity> patientAllergy);

}
