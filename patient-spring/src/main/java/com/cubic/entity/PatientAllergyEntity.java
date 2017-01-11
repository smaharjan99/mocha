package com.cubic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cubic.rest.vo.Status;

@Entity
@Table(name = "PATIENT_ALLERGIES")
public class PatientAllergyEntity {

	@Id
	@Column(name = "ALLERGY_ID")
	private String allergyId;
	@Column(name = "ALLERGY_NAME")
	private String allergyName;
	@Enumerated(EnumType.STRING)
	@Column(name = "ACTIVATE")
	private Status activate;
	@Column(name = "ACTIVATED_DATE")
	private String activatedDate;
	@Column(name = "DEACTIVATED_DATE")
	private String deactivatedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_FK")
	private PatientInfoEntity patientAllergyId;

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

	public PatientInfoEntity getPatientAllergyId() {
		return patientAllergyId;
	}

	public void setPatientAllergyId(PatientInfoEntity patientAllergyId) {
		this.patientAllergyId = patientAllergyId;
	}

	@Override
	public String toString() {
		return "PatientAllergyEntity [allergyId=" + allergyId + ", allergyName=" + allergyName + ", activate="
				+ activate + ", activatedDate=" + activatedDate + ", deactivatedDate=" + deactivatedDate
				+ ", patientAllergyId=" + patientAllergyId + "]";
	}

}
