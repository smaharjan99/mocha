package com.cubic.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {

	@Id
	@Column(name = "CUSTOMER_ID")
	@SequenceGenerator(name = "customerSeq", sequenceName = "CUSTOMERSEQ", allocationSize = 1)
	@GeneratedValue(generator = "customerSeq")
	private Long pk;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "SSN")
	private String ssn;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<AddressEntity> addressList = null;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<AddressEntity> getAddressList() {
		if (addressList == null) {
			addressList = new ArrayList<AddressEntity>();
		}
		return addressList;
	}

	public void setAddressList(List<AddressEntity> addressList) {

		this.addressList = addressList;

	}

	@Override
	public String toString() {
		return "CustomerEntity [pk=" + pk + ", firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn
				+ "]";
	}

}
