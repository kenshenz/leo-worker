package com.ksn.leo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	static Logger logger = LoggerFactory.getLogger("leo-worker");
	static AbstractApplicationContext context;

	public static void main(String[] args) throws InterruptedException {
		context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		logger.info("leo-worker 启动完成!!!");
		context.registerShutdownHook();
		context.start();
		
		while (context.isActive()) {
			Thread.sleep(500);
		}
	}

}
