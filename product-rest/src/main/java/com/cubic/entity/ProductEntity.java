package com.cubic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.cubic.rest.vo.Category;
import com.cubic.rest.vo.Status;

@Entity
@Table(name = "PRODUCTS")
@NamedQueries({
		@NamedQuery(name = QueryConstants.PRODUCT_SEARCH, query = "select p from ProductEntity p where UPPER(p.productName) like UPPER(?)"),
		@NamedQuery(name = QueryConstants.PRODUCT_ALL_RECORDS, query = "select p from ProductEntity p") })
public class ProductEntity {

	@Id
	@Column(name = "PRODUCT_ID")
	/*
	 * @SequenceGenerator(name = "customerSeq", sequenceName = "CUSTOMERSEQ",
	 * allocationSize = 1)
	 * 
	 * @GeneratedValue(generator = "customerSeq")
	 */
	private String pk;

	@Enumerated(EnumType.STRING)
	@Column(name = "Category")
	private Category category;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "UPC")
	private String upc;

	@Column(name = "PRODUCT_Price")
	private String price;

	@Column(name = "QUANTITY")
	private String quantity;

	@Enumerated(EnumType.STRING)
	@Column(name = "ACTIVATE")
	private Status activate;

	@Column(name = "ACTIVATE_DATE")
	private String activateDate;

	@Column(name = "INACTIVATE_DATE")
	private String inactivateDate;

	@Column(name = "UPDATED_DATE")
	private String updatedDate;

	@Column(name = "CREATED_DATE")
	private String createdDate;

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getActivateDate() {
		return activateDate;
	}

	public void setActivateDate(String activateDate) {
		this.activateDate = activateDate;
	}

	public String getInactivateDate() {
		return inactivateDate;
	}

	public void setInactivateDate(String inactivateDate) {
		this.inactivateDate = inactivateDate;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Status getActivate() {
		return activate;
	}

	public void setActivate(Status activate) {
		this.activate = activate;
	}

	@Override
	public String toString() {
		return "ProductEntity [pk=" + pk + ", category=" + category + ", productName=" + productName + ", upc=" + upc
				+ ", price=" + price + ", quantity=" + quantity + ", activate=" + activate + ", activateDate="
				+ activateDate + ", inactivateDate=" + inactivateDate + ", updatedDate=" + updatedDate
				+ ", createdDate=" + createdDate + "]";
	}

}
