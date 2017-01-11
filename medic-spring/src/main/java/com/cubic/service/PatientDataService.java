package com.cubic.service;

import com.cubic.rest.vo.PatientData;

public interface PatientDataService {
	String createPatientData(final PatientData patientData);

	void modifyPatientData(final PatientData patientData);

	PatientData findPatientData(final String id);

}
