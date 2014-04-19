package org.ray.concurrent;

public class DeadLockTest {

	public static void main(String[] args) {
		Friend ray = new Friend("ray");
		Friend lee = new Friend("lee");
		
		new Thread(() -> {
			ray.bow(lee);
		}).start();
		new Thread(() -> {
			lee.bow(ray);
		}).start();
	}
	
	static class Friend {
		private String name;
		public Friend(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public synchronized void bow(Friend f) {
			System.out.println("Hello, " + f.getName());
			f.bowback(this);
		}
		
		public synchronized void bowback(Friend f) {
			System.out.println("Nice to meet you, " + f.getName());
		}
		
	}
	
}
