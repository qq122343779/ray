package org.ray.lambda.template;


public class JdbcTemplate {

	
	public void execute(CallBack callback) {
		System.out.println("get connnection");
		callback.doExecute(null);
		System.out.println("close connection");
	}
	
}
