package org.ray.time.enums;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import org.junit.Test;

public class DayOfWeekAndMonthTest {

	@Test
	public void dateOfWeekTest() {
		System.out.printf("%s%n", DayOfWeek.FRIDAY.plus(4));
		
		System.out.printf("%s%n", Month.AUGUST.plus(4));
	}

	@Test
	public void displayTest() {
		System.out.printf("%s%n", DayOfWeek.FRIDAY.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
		System.out.printf("%s%n", DayOfWeek.FRIDAY.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
		System.out.printf("%s%n", DayOfWeek.FRIDAY.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.ENGLISH));
		
		System.out.printf("%s%n", Month.AUGUST.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
		System.out.printf("%s%n", Month.AUGUST.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
		System.out.printf("%s%n", Month.AUGUST.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.ENGLISH));
	}
}
