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

import com.cubic.rest.vo.AddressType;
import com.cubic.rest.vo.Status;

@Entity
@Table(name = "PATIENT_ADDRESS")
public class PatientAddressEntity {

	@Id
	@Column(name = "ADDRESS_ID")
	private String addressId;
	@Column(name = "STREET")
	private String street;
	@Column(name = "ADDRESS_LINE")
	private String addLine;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "ZIP")
	private String zip;
	@Enumerated(EnumType.STRING)
	@Column(name = "ADDR_TYPE")
	private AddressType addType;
	@Column(name = "CURR_ADDR")
	private String currAddress;
	@Enumerated(EnumType.STRING)
	@Column(name = "ACTIVATE")
	private Status activate;
	@Column(name = "ACTIVATED_DATE")
	private String activatedDate;
	@Column(name = "DEACTIVATED_DATE")
	private String deactivatedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_AD_FK")
	private PatientInfoEntity patientAddressId;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddLine() {
		return addLine;
	}

	public void setAddLine(String addLine) {
		this.addLine = addLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public AddressType getAddType() {
		return addType;
	}

	public void setAddType(AddressType addType) {
		this.addType = addType;
	}

	public String getCurrAddress() {
		return currAddress;
	}

	public void setCurrAddress(String currAddress) {
		this.currAddress = currAddress;
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

	public PatientInfoEntity getPatientAddressId() {
		return patientAddressId;
	}

	public void setPatientAddressId(PatientInfoEntity patientAddressId) {
		this.patientAddressId = patientAddressId;
	}

	@Override
	public String toString() {
		return "PatientAddressEntity [addressId=" + addressId + ", street=" + street + ", addLine=" + addLine
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", addType=" + addType + ", currAddress="
				+ currAddress + ", activatedDate=" + activatedDate + ", deactivatedDate=" + deactivatedDate + "]";
	}

}
