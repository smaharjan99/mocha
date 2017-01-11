package com.cubic.rest.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PatientAllergy {

	private String patientId;
	private String allergyId;
	private String activate;
	private String activatedDate;
	private String deactivatedDate;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(String allergyId) {
		this.allergyId = allergyId;
	}

	public String getActivate() {
		return activate;
	}

	public void setActivate(String activate) {
		this.activate = activate;
	}

	public String getActivatedDate() {
		return activatedDate;
	}

	public void setActivatedDate(String activatedDate) {
		this.activatedDate = activatedDate;
	}

	public String getDeactivatedDate() {
		return deactivatedDate;
	}

	public void setDeactivatedDate(String deactivatedDate) {
		this.deactivatedDate = deactivatedDate;
	}

	@Override
	public String toString() {
		return "PatientAllergies [patientId=" + patientId + ", allergyId=" + allergyId + ", activate=" + activate
				+ ", activatedDate=" + activatedDate + ", deactivatedDate=" + deactivatedDate + "]";
	}

}
