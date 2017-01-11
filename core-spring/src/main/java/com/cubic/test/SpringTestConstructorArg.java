package com.cubic.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cubic.spring.Manufacturer;
import com.cubic.spring.ProductServiceImpV1;
import com.cubic.spring.SpringFactory;

public class SpringTestConstructorArg {

	public static void main(String[] args) {

		ProductServiceImpV1 ps = SpringFactory.getInstance().getBean("psV1Obj3", ProductServiceImpV1.class);

		System.out.println("Version - " + ps.getVersion());
		System.out.println("Manufacturer - " + ps.getManufacturer());
		System.out.println("Max Value - " + ps.getMaxValue());

		List<String> comments = ps.getComments();
		System.out.println(comments);
		Set<Manufacturer> manufacturers = ps.getManufacturers();
		System.out.println(manufacturers);
		Map<Manufacturer, Double> priceMap = ps.getPriceMap();
		System.out.println(priceMap);

	}

}
