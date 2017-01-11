package com.cubic.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cubic.spring.ProductServiceImpV1;
import com.cubic.spring.ProductVo;

public class SpringTest1 {

	public static void main(String[] args) {
		ProductVo vo = new ProductVo();
		vo.setProductName("pixel");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringContext.xml");
		ProductServiceImpV1 ps = context.getBean("psV1Obj1", ProductServiceImpV1.class);
		ProductServiceImpV1 ps1 = context.getBean("psV1Obj2", ProductServiceImpV1.class);
		// ProductService ps = context.getBean(ProductService.class);
		ProductVo result = ps.createProduct(vo);
		System.out.println(result);
		result = ps1.createProduct(vo);
		System.out.println(result);

		context.close();
	}

}
