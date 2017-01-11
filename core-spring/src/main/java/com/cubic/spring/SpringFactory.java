package com.cubic.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringFactory {

	private final static SpringFactory instance = new SpringFactory();
	private ApplicationContext context = null;
	String[] configs = { "SpringContext.xml", "CommonConfig.xml" };

	private SpringFactory() {
		context = new ClassPathXmlApplicationContext(configs);
	}

	public static SpringFactory getInstance() {
		return instance;
	}

	public ApplicationContext getSpringContext() {
		return context;
	}

	public <T> T getBean(Class<T> className) {
		return context.getBean(className);
	}

	public <T> T getBean(String name, Class<T> className) {
		return context.getBean(name, className);
	}

	public Object getBean(String name) {
		return context.getBean(name);
	}

	public void close() {
		((ClassPathXmlApplicationContext) context).close();
	}

}
