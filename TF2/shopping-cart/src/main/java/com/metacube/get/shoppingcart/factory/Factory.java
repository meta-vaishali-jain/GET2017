package com.metacube.get.shoppingcart.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Factory {
	static ApplicationContext applicationContext;
	
	static{
		applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}
	
	static public ApplicationContext getApplicationContext(){
		return applicationContext;
	}
}
