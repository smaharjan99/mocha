package com.cubic.spring;

public abstract class AbstractService {

	private String manufacturer;
	private String version;
	private int maxValue;

	public AbstractService() {
	}

	public AbstractService(String manufacturer, String version, int maxValue) {
		super();
		this.manufacturer = manufacturer;
		this.version = version;
		this.maxValue = maxValue;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ProductServiceImpV1 [manufacturer=" + manufacturer + ", version=" + version + "]";
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

}
