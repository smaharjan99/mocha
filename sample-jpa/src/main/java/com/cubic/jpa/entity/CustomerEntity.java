package com.cubic.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cubic.jpa.test.QueryConstants;

@Entity
@Table(name = "CUSTOMER")
@NamedQueries({
		@NamedQuery(name = QueryConstants.CUSTOMER_SEARCH, query = "select c from CustomerEntity c where c.firstName like ? OR c.lastName like ?"),
		@NamedQuery(name = QueryConstants.CUSTOMER_ALL_RECORDS, query = "select c from CustomerEntity c"),
		@NamedQuery(name = QueryConstants.CUSTOMER_COUNT, query = "select count(*) from CustomerEntity")

})
@NamedNativeQueries({
		@NamedNativeQuery(name = QueryConstants.CUSTOMER_NATIVE_ALL, query = "select CUSTOMER_ID, FIRST_NAME, LAST_NAME, SSN from Customer", resultClass = CustomerEntity.class),
		@NamedNativeQuery(name = QueryConstants.CUSTOMER_NATIVE_SELECT_NAME, query = "select CUSTOMER_ID, FIRST_NAME from Customer"),
		@NamedNativeQuery(name = QueryConstants.CUSTOMER_NATIVE_COUNT, query = "select count(*) from Customer")

})

@EntityListeners({ CustomerLogListerner.class, CustomerAuditListerner.class })
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

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cust")
	private CustomerDetailEntity customerInfo;

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

	public CustomerDetailEntity getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerDetailEntity customerInfo) {
		this.customerInfo = customerInfo;
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
