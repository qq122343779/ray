package org.ray.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

public class AtomicTest {

	ExecutorService exe;
	
	@Before
	public void setUp() throws InterruptedException {
		ThreadPoolExecutor e = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		e.prestartAllCoreThreads();
		
		this.exe = e;
	}
	
	@Test
	public void test() throws InterruptedException {
		Counter c = new Counter();
		exe.execute(() -> {
			c.increment();
			c.increment();
			c.increment();
			System.out.println(c.value());
		});
		exe.execute(() -> {
			c.decrement();
			c.decrement();
			c.decrement();
			System.out.println(c.value());
		});
		exe.execute(() -> {
			c.increment();
			c.increment();
			c.increment();
			System.out.println(c.value());
		});
		exe.execute(() -> {
			c.decrement();
			c.decrement();
			c.decrement();
			System.out.println(c.value());
		});
		
		TimeUnit.SECONDS.sleep(4);
		System.out.println(c.value());
	}
	
}
