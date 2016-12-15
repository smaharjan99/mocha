package com.cubic.service;

import java.util.List;

import com.cubic.rest.vo.Product;

public interface ProductService {

	String createProduct(final Product product);

	List<Product> allProduct();

	void modifyProduct(final Product product);

	void removeProduct(final String id);

	Product findProduct(final String id);

	List<Product> searchProduct(final String productName);

}
