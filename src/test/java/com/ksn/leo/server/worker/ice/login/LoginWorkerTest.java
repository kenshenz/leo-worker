package com.ksn.leo.server.worker.ice.login;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ksn.leo.rpc.ice.login.LoginReq;
import com.ksn.leo.rpc.ice.login.LoginResp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
@FixMethodOrder
public class LoginWorkerTest {
	@Autowired
	private LoginWorker worker;

	@Test
	public void test1() {
		LoginReq req = new LoginReq("kenshenz", "kenshenz");
		LoginResp resp = worker.login(req);
		
	}

}
