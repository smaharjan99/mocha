package com.cubic.spring;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductServiceImpV1 extends AbstractService implements ProductService {

	public void init() {
		// this.version = "1.0.1";
	}

	private NotificationService notifyService;

	private List<String> comments;
	private Set<Manufacturer> manufacturers;
	private Map<Manufacturer, Double> priceMap;

	public ProductServiceImpV1() {

	}

	public ProductServiceImpV1(final String manufacturer, final String version, final int maxValue) {
		super(manufacturer, version, maxValue);

	}

	public ProductVo createProduct(ProductVo vo) {
		vo.setVersion(this.getVersion());
		vo.setProductId((long) (Math.random() * getMaxValue()));
		vo.setManufacturer(this.getManufacturer());
		this.getNotifyService().notifyCustomer(vo);
		return vo;
	}

	public NotificationService getNotifyService() {
		return notifyService;
	}

	public void setNotifyService(NotificationService notifyService) {
		this.notifyService = notifyService;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public Set<Manufacturer> getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(Set<Manufacturer> manufacturers) {
		this.manufacturers = manufacturers;
	}

	public Map<Manufacturer, Double> getPriceMap() {
		return priceMap;
	}

	public void setPriceMap(Map<Manufacturer, Double> priceMap) {
		this.priceMap = priceMap;
	}

	public void end() {
		System.out.println("ended");
	}

}
