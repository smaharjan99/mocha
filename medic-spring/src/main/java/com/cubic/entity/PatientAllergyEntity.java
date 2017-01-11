package com.cubic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT_ALLERGY")
public class PatientAllergyEntity {

	@Id
	@Column(name = "ALLERGY_ID")

	private String allergyId;
	/*
	 * @Column(name = "PATIENT_ID") private String patientId;
	 */

	@Column(name = "ACTIVATE")
	private String activate;
	@Column(name = "ACTIVATED_DATE")
	private String activatedDate;
	@Column(name = "DEACTIVATED_DATE")
	private String deactivatedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID")
	private PatientInfoEntity patientAllergyId;

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

	public PatientInfoEntity getPatientAllergyId() {
		return patientAllergyId;
	}

	public void setPatientAllergyId(PatientInfoEntity patientAllergyId) {
		this.patientAllergyId = patientAllergyId;
	}

	@Override
	public String toString() {
		return "PatientAllergyEntity [ allergyId=" + allergyId + ", activate=" + activate + ", activatedDate="
				+ activatedDate + ", deactivatedDate=" + deactivatedDate + "]";
	}

}
