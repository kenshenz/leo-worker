package com.ksn.leo.server.worker.ice;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.ksn.core.rpc.ice.CommunicatorFactory;
import com.ksn.core.worker.annonation.Worker;

import Ice.Communicator;
import Ice.ObjectAdapter;

@Component
public class IceWorkerFactory implements ApplicationContextAware {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private CommunicatorFactory factory;

	private ApplicationContext context;

	@PostConstruct
	public void init() {
		// 注册ice worker
		Communicator ic = factory.getCommunicator();

		ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints("LeoServer", "default -p 10000");
		Map<String, Object> workers = context.getBeansWithAnnotation(Worker.class);
		
		for (String key : workers.keySet()) {
			Object worker = context.getBean(key);
			Class<?> target = AopProxyUtils.ultimateTargetClass(worker);
			Worker workerAnnotation = target.getAnnotation(Worker.class);
			adapter.add((Ice.Object) worker, ic.stringToIdentity(workerAnnotation.name()));
			logger.info("登记worker: id=" + workerAnnotation.id() + " name=" + workerAnnotation.name() + " version="
					+ workerAnnotation.version());
		}

		logger.info("启动Ice Object Adapter: LeoServer, default -p 10000");
		adapter.activate();

//		ic.waitForShutdown(); 在spring容器中不需要

	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

}
