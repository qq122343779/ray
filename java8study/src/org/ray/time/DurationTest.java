package org.ray.time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class DurationTest {

	@Test
	public void test() {
		Instant i1 = Instant.now();
		Instant i2 = i1.plusSeconds(50);
		long s = Duration.between(i1, i2).getSeconds();
		System.out.println(s);
		
		Duration gap = Duration.of(10, ChronoUnit.SECONDS);
		Instant i3 = i1.plus(gap);
		System.out.println(i1);
		System.out.println(i3);
	}
	
	@Test
	public void betweenTest() {
		Instant i1 = Instant.now();
		Instant i2 = i1.plusSeconds(50);
		long s = ChronoUnit.SECONDS.between(i1, i2);
		System.out.println(s);
	}
	
}
