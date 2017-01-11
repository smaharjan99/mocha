package com.cubic.rest.vo;

import java.util.List;

public class PatientInfoSearchResult {
	private List<PatientInfo> patientInfo = null;

	public PatientInfoSearchResult() {

	}

	public PatientInfoSearchResult(List<PatientInfo> patientInfo) {
		this.patientInfo = patientInfo;
	}

	public List<PatientInfo> getPatientInfo() {
		return patientInfo;
	}

	public void setPatientInfo(List<PatientInfo> patientInfo) {
		this.patientInfo = patientInfo;
	}

}
