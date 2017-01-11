package com.cubic.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.cubic.rest.vo.Status;

@Service("jpaPS")
@Transactional
public class ProductServiceImpl implements ProductService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ProductMapper mapper;

	DateFormat dateType = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();

	public String createProduct(final Product product) {
		validateInfo(product);
		validateUPC(product.getUpc());
		if (product.getProductName().length() < 3) {
			throw new InvalidDataException("Product Name Minimum length 3 or more");
		}

		ProductEntity entity = mapper.mapToProductEntity(new ProductEntity(), product);

		entity.setPk(UUID.randomUUID().toString());
		if (product.getActivate() == Status.ACTIVE) {
			entity.setActivateDate(dateType.format(date));
		} else {
			entity.setInactivateDate(dateType.format(date));
		}
		entity.setCreatedDate(dateType.format(date));
		em.persist(entity);
		return entity.getPk();
	}

	public void modifyProduct(Product product) {
		validateInfo(product);
		validateUPC(product.getUpc());
		if (product.getProductName().length() < 3) {
			throw new InvalidDataException("Product Name Minimum length 3 or more");
		}
		ProductEntity entity = em.find(ProductEntity.class, new String(product.getId()));
		if (entity == null) {
			throw new ProductNotFoundException("Product Not Found in the data");
		}

		entity = mapper.mapToProductEntity(entity, product);
		if (product.getActivate() == Status.ACTIVE) {
			entity.setActivateDate(dateType.format(date));
		} else {
			entity.setInactivateDate(dateType.format(date));
		}
		entity.setUpdatedDate(dateType.format(date));
		em.persist(entity);

	}

	public void removeProduct(String id) {
		validateId(id);
		ProductEntity entity = em.find(ProductEntity.class, new String(id));
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
		TypedQuery<ProductEntity> query = em.createNamedQuery(QueryConstants.PRODUCT_ALL_RECORDS, ProductEntity.class);
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

	public List<Product> findProductUPC(String upc) {
		TypedQuery<ProductEntity> query = em.createNamedQuery(QueryConstants.PRODUCT_UPC, ProductEntity.class);
		query.setParameter(1, upc);
		List<ProductEntity> upcResult = query.getResultList();
		return mapper.mapToProductList(upcResult);
	}

	/*
	 * public Product findProductUPC(String upc) { ProductEntity entity =
	 * em.find(ProductEntity.class, new String(upc)); if (entity == null) {
	 * throw new ProductNotFoundException("Product Not Found in the data"); }
	 * return mapper.mapToProduct(entity); }
	 */

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
		String expression = "^\\d{1}-\\d{5}-\\d{5}-\\d{1}$";
		if (StringUtils.isEmpty(upc) || !upc.trim().matches(expression)) {
			throw new UPCException("Invalid UPC in the product");
		}
	}

}
