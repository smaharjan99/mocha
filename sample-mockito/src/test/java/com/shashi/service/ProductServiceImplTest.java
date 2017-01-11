package com.shashi.service;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.shashi.dao.ProductDAO;
import com.shashi.dao.ProductDetailDAO;
import com.shashi.entity.ProductEntity;
import com.shashi.service.exception.ProductException;
import com.shashi.util.ProductData;
import com.shashi.vo.ProductVO;

@RunWith(MockitoJUnitRunner.class)

public class ProductServiceImplTest {

	@Mock
	private ProductDAO productDao;

	@Mock
	private ProductDetailDAO detailDao;

	@Spy
	private ProductServiceImpl impl;
	ProductVO input;
	ProductEntity output;

	// ProductServiceImpl impl = new ProductServiceImpl();

	@Before
	public void setup() {
		input = ProductData.createProduct();
		output = ProductData.createProductEntity();
		when(impl.getDao()).thenReturn(productDao);
		when(impl.getDetailDao()).thenReturn(detailDao);

		/*
		 * impl.setDao(productDao); impl.setDetailDao(detailDao);
		 */
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSaveProductNullProduct() {
		ProductServiceImpl impl = new ProductServiceImpl();
		impl.saveProduct(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSaveProductNullProductName() {
		ProductServiceImpl impl = new ProductServiceImpl();
		ProductVO input = ProductData.createProduct();
		impl.saveProduct(null);
		impl.saveProduct(input);
	}

	@Test
	public void testSaveProduct() throws SQLException {
		when(productDao.createProduct(any(ProductEntity.class))).thenReturn(output);
		ProductVO result = impl.saveProduct(input);
		verifyInfo(result);
		verify(productDao, never()).find(any(Long.class));
		verify(productDao).createProduct(any(ProductEntity.class));
		verify(detailDao).saveProductDetail(any(ProductEntity.class));
	}

	@Test
	public void testUpdateProduct() throws SQLException {
		input.setId(new Long(2000));
		input.setProductName("Google");

		when(productDao.find(any(Long.class))).thenReturn(output);
		ProductVO result = impl.saveProduct(input);
		verifyInfo(result);
		assertEquals(input.getId(), result.getId());
		verify(productDao).find(any(Long.class));
		verify(productDao, never()).createProduct(any(ProductEntity.class));
		verify(productDao).updateProduct(any(ProductEntity.class));
		verify(detailDao).saveProductDetail(any(ProductEntity.class));

	}

	@Test(expected = ProductException.class)
	public void testUpdateProductSQLException() throws SQLException {
		input.setId(new Long(2000));
		input.setProductName("Google");

		when(productDao.find(any(Long.class))).thenThrow(new SQLException("Database credentials invalid"));
		impl.saveProduct(input);

	}

	@Test
	public void testUpdateProductCheckOrder() throws SQLException {
		input.setId(new Long(2000));
		input.setProductName("Google");

		when(productDao.find(any(Long.class))).thenReturn(output);
		ProductVO result = impl.saveProduct(input);
		verifyInfo(result);
		assertEquals(input.getId(), result.getId());

		InOrder inorder = inOrder(productDao, detailDao);

		inorder.verify(productDao).find(any(Long.class));
		inorder.verify(productDao, never()).createProduct(any(ProductEntity.class));
		inorder.verify(productDao).updateProduct(any(ProductEntity.class));
		inorder.verify(detailDao).saveProductDetail(any(ProductEntity.class));

	}

	private void verifyInfo(ProductVO result) {
		assertNotNull(result);
		assertNotNull(result.getId());
		assertEquals(input.getProductName(), result.getProductName());
	}

}
