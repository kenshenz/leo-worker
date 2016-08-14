module com {
module ksn {
module leo {
module rpc {
module ice {
	module register {
		struct RegisterReq {
			string username;
			string password;
		};
		
		struct RegisterResp {
			string code;
			string msg;
		};
	
		interface RegisterWorker {
			RegisterResp register(RegisterReq req);
		};
	};
};
};
};
};
};