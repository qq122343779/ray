package org.ray.time;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class InstantTest {

	@Test
	public void test() {
		Instant instant = Instant.now().plus(1, ChronoUnit.HOURS);
		System.out.printf("one hour later: " + instant);
	}
	
}
