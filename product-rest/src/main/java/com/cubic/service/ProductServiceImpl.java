package com.cubic.service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cubic.entity.ProductEntity;
import com.cubic.entity.QueryConstants;
import com.cubic.rest.exception.InvalidDataException;
import com.cubic.rest.exception.ProductNotFoundException;
import com.cubic.rest.exception.UPCException;
import com.cubic.rest.vo.Product;

@Service("jpaPS")
@Transactional
public class ProductServiceImpl implements ProductService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ProductMapper mapper;

	public String createProduct(final Product product) {
		ProductEntity entity = mapper.mapToProductEntity(new ProductEntity(), product);
		validateUPC(entity.getUpc());
		validateInfo(product);
		entity.setPk(UUID.randomUUID().toString());
		em.persist(entity);
		return entity.getPk().toString();
	}

	public void modifyProduct(Product product) {
		ProductEntity entity = em.find(ProductEntity.class, new String(product.getId()));
		if (entity == null) {
			throw new ProductNotFoundException("Product Not Found in the data");
		}
		validateUPC(entity.getUpc());
		entity = mapper.mapToProductEntity(entity, product);
		em.persist(entity);

	}

	public void removeProduct(String id) {
		ProductEntity entity = em.find(ProductEntity.class, new String(id));
		validateId(id);
		em.remove(entity);

	}

	public List<Product> searchProduct(String productName) {
		productName = StringUtils.isEmpty(productName) ? "%" : productName.trim() + "%";
		TypedQuery<ProductEntity> query = em.createNamedQuery(QueryConstants.PRODUCT_SEARCH, ProductEntity.class);
		query.setParameter(1, productName);
		List<ProductEntity> searchResults = query.getResultList();
		return mapper.mapToProductList(searchResults);
	}

	public List<Product> allProduct() {
		// productName = StringUtils.isEmpty(productName) ? "%" :
		// productName.trim() + "%";
		TypedQuery<ProductEntity> query = em.createNamedQuery(QueryConstants.PRODUCT_ALL_RECORDS, ProductEntity.class);
		// query.setParameter(1, productName);
		List<ProductEntity> allResults = query.getResultList();
		return mapper.mapToAllProductList(allResults);
	}

	public Product findProduct(String id) {
		ProductEntity entity = em.find(ProductEntity.class, new String(id));
		if (entity == null) {
			throw new ProductNotFoundException("Product Not Found in the data");
		}
		return mapper.mapToProduct(entity);
	}

	private void validateId(final String id) {
		if (StringUtils.isEmpty(id)) {
			throw new InvalidDataException("Invalid ID to find the product");
		}
	}

	private void validateInfo(final Product product) {
		if (product == null || StringUtils.isEmpty(product.getProductName())) {
			throw new InvalidDataException("Invalid data in the system");
		}
	}

	private void validateUPC(final String upc) {
		String expression = "^(\\d{1}-?\\d{5}-?\\d{5}-?\\d{1}|X-XXXXX-XXXXX-X)$";
		if (StringUtils.isEmpty(upc) || !upc.trim().matches(expression)) {
			throw new UPCException("Invalid UPC in the product");
		}
	}

}
