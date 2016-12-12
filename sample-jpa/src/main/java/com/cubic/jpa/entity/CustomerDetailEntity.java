package com.cubic.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CUSTOMER_INFO")
public class CustomerDetailEntity {

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "custDetailGen", strategy = "foreign", parameters = @Parameter(name = "property", value = "cust") )
	@GeneratedValue(generator = "custDetailGen")
	private Long pk;

	@Column(name = "DESCRIPTION")
	private String description;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private CustomerEntity cust;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CustomerEntity getCust() {
		return cust;
	}

	public void setCust(CustomerEntity cust) {
		this.cust = cust;
	}

	@Override
	public String toString() {
		return "CustomerDetailEntity [pk=" + pk + ", description=" + description + "]";
	}

}
