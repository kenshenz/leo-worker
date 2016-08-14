package com.ksn.leo.server.worker.ice.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ksn.core.annonation.LoggerAnnotation;
import com.ksn.core.pojo.resp.Response;
import com.ksn.core.worker.annonation.Worker;
import com.ksn.leo.rpc.ice.login.LoginReq;
import com.ksn.leo.rpc.ice.login.LoginResp;
import com.ksn.leo.rpc.ice.login._LoginWorkerDisp;
import com.ksn.leo.server.service.login.LoginService;

import Ice.Communicator;
import Ice.Current;

@Worker(id = "LoginWorker", name = "LoginWorker", version = "1.0.0")
@Component
public class LoginWorker extends _LoginWorkerDisp implements IceBox.Service {
	private static final long serialVersionUID = 7659528130285006970L;

	Logger logger = LoggerFactory.getLogger(getClass());
	
	private Ice.ObjectAdapter adapter;

	@Autowired
	private LoginService loginService;

	@LoggerAnnotation(desc = "登录worker")
	public LoginResp login(LoginReq req, Current __current) {
		logger.info("login worker");
		Response resp = loginService.login(req.username, req.password);
		LoginResp iceResp = new LoginResp();
		iceResp.code = resp.getCode();
		iceResp.msg = resp.getMsg();
		return iceResp;
	}

	public void start(String name, Communicator communicator, String[] args) {
		adapter = communicator.createObjectAdapter(name);
		adapter.add(this, communicator.stringToIdentity("LoginWorker"));
		adapter.activate();
	}

	public void stop() {
		adapter.deactivate();
	}

}
