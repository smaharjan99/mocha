package com.cubic.service;

import java.util.List;

import com.cubic.entity.PatientInfoEntity;
import com.cubic.rest.vo.PatientData;
import com.cubic.rest.vo.PatientInfo;

public interface PatientInfoService {

	PatientInfoEntity createPatientInfo(final PatientInfo patientInfo);

	void modifyPatientInfo(final PatientInfo patientInfo);

	PatientInfoEntity findPatientInfo(final PatientData patientData, final String id);

	List<PatientInfo> searchPatient(final String firstName, final String lastName);
}
