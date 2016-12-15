package com.cubic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubic.entity.ProductEntity;
import com.cubic.rest.vo.Product;

@Component
public class ProductMapper {

	public Product mapToProduct(final ProductEntity entity) {
		Product result = new Product();
		result.setCategory(entity.getCategory());
		result.setProductName(entity.getProductName());
		result.setUpc(entity.getUpc());
		result.setProductPrice(entity.getPrice());
		result.setQuantity(entity.getQuantity());
		result.setActivate(entity.getActivate());
		result.setActivateDate(entity.getActivateDate());
		result.setInactivateDate(entity.getInactivateDate());
		result.setUpdateDate(entity.getUpdatedDate());
		result.setCreateDate(entity.getCreatedDate());
		result.setId(entity.getPk());

		return result;
	}

	public ProductEntity mapToProductEntity(final ProductEntity entity, final Product product) {

		entity.setCategory(product.getCategory());
		entity.setProductName(product.getProductName());
		entity.setUpc(product.getUpc());
		entity.setPrice(product.getProductPrice());
		entity.setQuantity(product.getQuantity());
		entity.setActivate(product.getActivate());
		entity.setActivateDate(product.getActivateDate());
		entity.setInactivateDate(product.getInactivateDate());
		entity.setUpdatedDate(product.getUpdateDate());
		entity.setCreatedDate(product.getCreateDate());

		return entity;
	}

	public List<Product> mapToProductList(final List<ProductEntity> entities) {
		List<Product> results = new ArrayList<Product>();
		if (entities != null && !entities.isEmpty()) {
			for (ProductEntity entity : entities) {
				results.add(mapToProduct(entity));
			}
		}
		return results;
	}

	public List<Product> mapToAllProductList(final List<ProductEntity> entities) {
		List<Product> allResults = new ArrayList<Product>();
		if (entities != null && !entities.isEmpty()) {
			for (ProductEntity entity : entities) {
				allResults.add(mapToProduct(entity));
			}
		}
		return allResults;
	}

}
