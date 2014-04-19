package org.ray.lambda.template;

import java.sql.Connection;

@FunctionalInterface
public interface CallBack {

	void doExecute(Connection conn);
	
}
