package org.ray.concurrent.interrupt;

import java.util.concurrent.TimeUnit;

public class SleepTest {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(SleepTest::sleepMessage);
		t.start();
		
		TimeUnit.SECONDS.sleep(3);
		t.interrupt();
		TimeUnit.HOURS.sleep(4);
	}
	
	public static void sleepMessage() {
		for (int i = 0; i < 4; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.println("ops: who interrupted me!");
				return;
			}
			System.out.printf("msg: %d\n", i);
		}
	}
}
