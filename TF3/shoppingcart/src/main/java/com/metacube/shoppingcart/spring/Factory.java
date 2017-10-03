package com.metacube.shoppingcart.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * ClassName : Factory
 * @author   : Vaishali Jain
 * Description: creating instance of ApplicationContext
 */
public class Factory {
	
	static ApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
	
	}

	static public ApplicationContext getApplicationContext()
	{
		return applicationContext;
	
	}
}
