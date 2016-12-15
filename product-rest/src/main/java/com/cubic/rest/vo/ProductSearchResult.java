package com.cubic.rest.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductSearchResult {
	private List<Product> product = null;

	public ProductSearchResult() {
	}

	public ProductSearchResult(List<Product> product) {
		this.product = product;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
