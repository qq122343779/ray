package org.ray.time;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class LocalTimeTest {

	@Test
	public void test() throws InterruptedException {
		for (;;) {
			LocalTime time = LocalTime.now();
			
			TimeUnit.SECONDS.sleep(1);
			System.out.printf("%d:%d:%d\n", time.getHour(), time.getMinute(), time.getSecond());
		}
	}
	
}
