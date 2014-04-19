package org.ray.concurrent.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptedTest {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(InterruptedTest::heavyCrunch);
		t.start();
		
		TimeUnit.SECONDS.sleep(3);
		t.interrupt();
		TimeUnit.HOURS.sleep(4);
	}
	
	public static void heavyCrunch() {
		for (int i = 0; i < 4; i++) {
			doHeavyCrunch();
			if (Thread.interrupted()) {
				System.out.println("ops: who interrupted me!");
				return;
			}
			
			System.out.printf("msg: %d\n", i);
		}
	}
	
	private static void doHeavyCrunch() {
		
	}
}
