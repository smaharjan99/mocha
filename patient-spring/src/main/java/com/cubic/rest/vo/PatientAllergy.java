package com.cubic.rest.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PatientAllergy {

	private String allergyId;
	private String allergyName;
	private Status activate;
	private String activatedDate;
	private String deactivatedDate;

	public String getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(String allergyId) {
		this.allergyId = allergyId;
	}

	public String getAllergyName() {
		return allergyName;
	}

	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}

	public Status getActivate() {
		return activate;
	}

	public void setActivate(Status activate) {
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
		return "PatientAllergy [allergyId=" + allergyId + ", allergyName=" + allergyName + ", activate=" + activate
				+ ", activatedDate=" + activatedDate + ", deactivatedDate=" + deactivatedDate + "]";
	}

}
