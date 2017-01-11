package com.shashi.util;

import com.shashi.entity.ProductEntity;
import com.shashi.vo.ProductVO;

public class ProductData {
	public static ProductVO createProduct() {
		ProductVO result = new ProductVO();
		result.setProductName("Samsung S7");
		result.setDescription("explodes on touch");
		return result;
	}

	public static ProductEntity createProductEntity() {
		ProductEntity results = new ProductEntity();
		results.setProductName("Samsung S7");
		results.setDescription("explodes on touch");
		results.setId(new Long(2000));
		return results;
	}
}
