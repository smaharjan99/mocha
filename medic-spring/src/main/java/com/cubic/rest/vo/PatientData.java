package com.cubic.rest.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PatientData {

	private PatientInfo patientInfo;

	private List<PatientAddress> patientAddress;

	private List<PatientAllergy> patientAllergy;

	public PatientInfo getPatientInfo() {
		return patientInfo;
	}

	public void setPatientInfo(PatientInfo patientInfo) {
		this.patientInfo = patientInfo;
	}

	public List<PatientAddress> getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(List<PatientAddress> patientAddress) {
		this.patientAddress = patientAddress;
	}

	public List<PatientAllergy> getPatientAllergy() {
		return patientAllergy;
	}

	public void setPatientAllergy(List<PatientAllergy> patientAllergy) {
		this.patientAllergy = patientAllergy;
	}

	@Override
	public String toString() {
		return "PatientData [patientInfo=" + patientInfo + ", patientAddress=" + patientAddress + ", patientAllergy="
				+ patientAllergy + "]";
	}

}
