package com.cubic.service;

import org.springframework.stereotype.Component;

import com.cubic.entity.PatientAllergyEntity;
import com.cubic.rest.vo.PatientAllergy;

@Component
public class PatientAllergyMapper {

	public PatientAllergy mapToPatientAllergy(final PatientAllergyEntity entity) {
		PatientAllergy result = new PatientAllergy();
		result.setAllergyName(entity.getAllergyName());
		result.setActivate(entity.getActivate());
		result.setActivatedDate(entity.getActivatedDate());
		result.setDeactivatedDate(entity.getDeactivatedDate());
		return result;
	}

	public PatientAllergyEntity mapToPatientAllergyEntity(final PatientAllergyEntity entity,
			final PatientAllergy patientAllergy) {
		entity.setAllergyName(patientAllergy.getAllergyName());
		entity.setActivate(patientAllergy.getActivate());
		entity.setActivatedDate(patientAllergy.getActivatedDate());
		entity.setDeactivatedDate(patientAllergy.getDeactivatedDate());
		return entity;
	}

}
