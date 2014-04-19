package org.ray.lambda;

import java.util.concurrent.Callable;

public class RetureTypeTest {
	
	void invoke(Runnable r) {
	    r.run();
	}

	<T> T invoke(Callable<T> c) {
	    try {
			return c.call();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		RetureTypeTest test = new RetureTypeTest();
		String t = test.invoke(() -> "done"); // T invoke(Callable<T> c)将执行，因为有返回值
		System.out.println(t);
	}
}
