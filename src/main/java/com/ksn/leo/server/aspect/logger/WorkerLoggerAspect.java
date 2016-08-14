package com.ksn.leo.server.aspect.logger;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ksn.core.annonation.LoggerAnnotation;
import com.ksn.core.aspect.LoggerAspect;
import com.ksn.core.utils.JSONUtils;
import com.ksn.core.utils.UUIDUtils;

@Aspect
@Component
public class WorkerLoggerAspect extends LoggerAspect {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Around(value = "execution(* com.ksn.leo.server.worker..*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		LoggerAnnotation annotation = method.getAnnotation(LoggerAnnotation.class);
		String uuid = UUIDUtils.generate();
		ReqLog reqLog = new ReqLog(uuid, pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(),
				Arrays.asList(pjp.getArgs()));
		logger.info(annotation.desc() + " req => " + JSONUtils.getGson().toJson(reqLog));
		Object rtnValue = pjp.proceed();
		RespLog respLog = new RespLog(uuid, rtnValue);
		logger.info(annotation.desc() + " resp => " + JSONUtils.getGson().toJson(respLog));
		return rtnValue;
	}

}
