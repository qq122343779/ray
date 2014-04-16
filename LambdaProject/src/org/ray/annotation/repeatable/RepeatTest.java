package org.ray.annotation.repeatable;

import java.util.Arrays;

import org.junit.Test;

public class RepeatTest {

	@Test
	public void test() {
		Authorizations auths = TestBean.class.getAnnotation(Authorizations.class);
		Arrays.asList(auths.value()).stream()
			.map(auth -> auth.value()[0])
			.forEach(s -> System.out.println(s));
	}

	@Test
	public void testSwitch() {
		String str = "ray";
		switch (str) {
			case "lee" : System.out.println("good");
			case "ray" : System.out.println("perfect");
			default : System.out.println("bad");
		}
	}
	
}
