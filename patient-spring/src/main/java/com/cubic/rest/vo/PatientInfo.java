package com.cubic.rest.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PatientInfo {

	private String id;
	private String firstName;
	private String lastName;
	private String dob;
	private String ssn;
	private String gender;
	private PreferredContact prefContact;
	private String contact;
	private Long patientId;
	private String emerName;
	private String emerContact;
	private String emerRelation;
	private String updatedDate;
	private String createdDate;
	private Status activate;
	private String activatedDate;
	private String deactivatedDate;

	private List<PatientAddress> patientAddress;

	private List<PatientAllergy> patientAllergy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public PreferredContact getPrefContact() {
		return prefContact;
	}

	public void setPrefContact(PreferredContact prefContact) {
		this.prefContact = prefContact;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getEmerName() {
		return emerName;
	}

	public void setEmerName(String emerName) {
		this.emerName = emerName;
	}

	public String getEmerContact() {
		return emerContact;
	}

	public void setEmerContact(String emerContact) {
		this.emerContact = emerContact;
	}

	public String getEmerRelation() {
		return emerRelation;
	}

	public void setEmerRelation(String emerRelation) {
		this.emerRelation = emerRelation;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
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

	public Status getActivate() {
		return activate;
	}

	public void setActivate(Status activate) {
		this.activate = activate;
	}

	@Override
	public String toString() {
		return "PatientInfo [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", ssn=" + ssn
				+ ", gender=" + gender + ", prefContact=" + prefContact + ", contact=" + contact + ", patientId="
				+ patientId + ", emerName=" + emerName + ", emerContact=" + emerContact + ", emerRelation="
				+ emerRelation + ", updatedDate=" + updatedDate + ", createdDate=" + createdDate + ", activatedDate="
				+ activatedDate + ", deactivatedDate=" + deactivatedDate + "]";
	}

}
