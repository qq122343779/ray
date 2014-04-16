package org.ray.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class PeriodTest {

	@Test
	public void test() {
		LocalDate now = LocalDate.now();
		LocalDate birth = LocalDate.of(1986, 11, 12);

		Period p = Period.between(birth, now);
		long p2 = ChronoUnit.DAYS.between(birth, now);
		System.out.println("You are " + p.getYears() + " years, "
				+ p.getMonths() + " months, and " + p.getDays()
				+ " days old. (" + p2 + " days total)");

		LocalDate nextBDay = birth.withYear(now.getYear());

		// If your birthday has occurred this year already, add 1 to the year.
		if (nextBDay.isBefore(now) || nextBDay.isEqual(now)) {
			nextBDay = nextBDay.plusYears(1);
		}

		Period p3 = Period.between(now, nextBDay);
		long p4 = ChronoUnit.DAYS.between(now, nextBDay);
		System.out.println("There are " + p3.getMonths() + " months, and "
				+ p3.getDays() + " days until your next birthday. (" + p4
				+ " days total)");
	}
	
}
