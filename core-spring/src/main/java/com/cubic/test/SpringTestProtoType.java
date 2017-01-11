package com.cubic.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cubic.spring.ProductServiceImpV1;
import com.cubic.spring.ProductVo;

public class SpringTestProtoType {

	public static void main(String[] args) {
		ProductVo vo = new ProductVo();
		vo.setProductName("pixel");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringContext.xml");
		ProductServiceImpV1 ps = context.getBean("psV1Obj1", ProductServiceImpV1.class);
		((com.cubic.spring.ProductServiceImpV1) ps).setManufacturer("Google");
		((com.cubic.spring.ProductServiceImpV1) ps).setVersion("1.2.2.2");
		ProductVo result = ps.createProduct(vo);
		System.out.println(result);
		ps = context.getBean("psV1Obj1", ProductServiceImpV1.class);
		result = ps.createProduct(vo);
		System.out.println(result);
	}

}
