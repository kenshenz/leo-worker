module com {
module ksn {
module leo {
module rpc {
module ice {
	module login {
		struct LoginReq {
			string username;
			string password;
		};
		
		struct LoginResp {
			string code;
			string msg;
		};
	
		interface LoginWorker {
			LoginResp login(LoginReq req);
		};
	};
};
};
};
};
};