package com.cubic.service;

import org.springframework.stereotype.Component;

import com.cubic.entity.PatientAddressEntity;
import com.cubic.rest.vo.PatientAddress;

@Component
public class PatientAddressMapper {

	public PatientAddress mapToPatientAddress(final PatientAddressEntity entity) {
		PatientAddress result = new PatientAddress();
		result.setStreet(entity.getStreet());
		result.setAddLine(entity.getAddLine());
		result.setCity(entity.getCity());
		result.setState(entity.getState());
		result.setZip(entity.getZip());
		result.setAddType(entity.getAddType());
		result.setCurrAddress(entity.getCurrAddress());
		result.setActiveDate(entity.getActivatedDate());
		result.setDeactiveDate(entity.getDeactivatedDate());

		return result;
	}

	public PatientAddressEntity mapToPatientAddressEntity(final PatientAddressEntity entity,
			final PatientAddress patientAddress) {
		entity.setStreet(patientAddress.getStreet());
		entity.setAddLine(patientAddress.getAddLine());
		entity.setCity(patientAddress.getCity());
		entity.setState(patientAddress.getState());
		entity.setZip(patientAddress.getZip());
		entity.setAddType(patientAddress.getAddType());
		entity.setCurrAddress(patientAddress.getCurrAddress());
		entity.setActivatedDate(patientAddress.getActiveDate());
		entity.setDeactivatedDate(patientAddress.getDeactiveDate());
		return entity;
	}

}
