package com.ksn.leo.server.service.login;

import org.springframework.stereotype.Service;

import com.ksn.core.annonation.LoggerAnnotation;
import com.ksn.core.pojo.resp.Response;

@Service
public class LoginService {
	
	@LoggerAnnotation(desc="登录service")
	public Response login(String username, String password) {
		if (username.toLowerCase().trim().equals(password.toLowerCase().trim())) {
			return Response.success();
		} else {
			return Response.failure();
		}
	}

}
