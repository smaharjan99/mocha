package com.cubic.rest.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PatientAddress {

	private String addressId;
	private String street;
	private String addLine;
	private String city;
	private String state;
	private String zip;
	private AddressType addType;
	private String currAddress;
	private Status activate;
	private String activeDate;
	private String deactiveDate;

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

	public String getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}

	public String getDeactiveDate() {
		return deactiveDate;
	}

	public void setDeactiveDate(String deactiveDate) {
		this.deactiveDate = deactiveDate;
	}

	@Override
	public String toString() {
		return "PatientAddress [street=" + street + ", addLine=" + addLine + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + ", addType=" + addType + ", currAddress=" + currAddress + ", activeDate="
				+ activeDate + ", deactiveDate=" + deactiveDate + "]";
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

}
