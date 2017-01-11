package com.cubic.service;

import java.util.List;

import com.cubic.rest.vo.PatientInfo;

public interface PatientInfoService {

	String createPatientInfo(final PatientInfo patientInfo);

	void modifyPatientInfo(final PatientInfo patientInfo);

	PatientInfo findPatientInfo(final String id);

	List<PatientInfo> searchPatientInfo(final String firstName, final String lastName);
}
