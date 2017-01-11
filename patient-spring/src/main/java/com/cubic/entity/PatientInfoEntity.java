package com.cubic.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cubic.rest.vo.PreferredContact;
import com.cubic.rest.vo.Status;

@Entity
@Table(name = "PATIENT_INFO")
public class PatientInfoEntity {

	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "DOB")
	private String dob;
	@Column(name = "SSN")
	private String ssn;
	@Column(name = "GENDER")
	private String gender;

	@Enumerated(EnumType.STRING)
	@Column(name = "PREFF_CONTACT")
	private PreferredContact prefContact;

	@Column(name = "CONTACT")
	private String contact;

	@Column(name = "PATIENT_ID")
	private Long patientId;
	@Column(name = "EMER_NAME")
	private String emerName;
	@Column(name = "EMER_CONTACT")
	private String emerContact;
	@Column(name = "EMER_RELATION")
	private String emerRelation;
	@Column(name = "UPDATED_DATE")
	private String updatedDate;
	@Column(name = "CREATED_DATE")
	private String createdDate;
	@Enumerated(EnumType.STRING)
	@Column(name = "ACTIVATE")
	private Status activate;
	@Column(name = "ACTIVATED_DATE")
	private String activatedDate;
	@Column(name = "DEACTIVATED_DATE")
	private String deactivatedDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patientAddressId")
	private List<PatientAddressEntity> addressList = null;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patientAllergyId")
	private List<PatientAllergyEntity> allergyList = null;

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

	public List<PatientAddressEntity> getAddressList() {
		if (addressList == null) {
			addressList = new ArrayList<PatientAddressEntity>();
		}
		return addressList;
	}

	public void setAddressList(List<PatientAddressEntity> addressList) {
		this.addressList = addressList;
	}

	public List<PatientAllergyEntity> getAllergyList() {
		if (allergyList == null) {
			allergyList = new ArrayList<PatientAllergyEntity>();
		}
		return allergyList;
	}

	public void setAllergyList(List<PatientAllergyEntity> allergyList) {
		this.allergyList = allergyList;
	}

	@Override
	public String toString() {
		return "PatientInfoEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", ssn=" + ssn + ", gender=" + gender + ", prefContact=" + prefContact + ", contact=" + contact
				+ ", patientId=" + patientId + ", emerName=" + emerName + ", emerContact=" + emerContact
				+ ", emerRelation=" + emerRelation + ", updatedDate=" + updatedDate + ", createdDate=" + createdDate
				+ ", activatedDate=" + activatedDate + ", deactivatedDate=" + deactivatedDate + "]";
	}

}
