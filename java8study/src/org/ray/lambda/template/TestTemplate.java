package org.ray.lambda.template;


public class TestTemplate {

	public static void main(String[] args) throws Exception {
		JdbcTemplate template = new JdbcTemplate();
		template.execute(
			conn -> {
				conn.toString();
			}
		);
	}
	
}
