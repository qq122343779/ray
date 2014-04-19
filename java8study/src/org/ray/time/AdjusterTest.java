package org.ray.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class AdjusterTest {

	@Test
	public void test() {
		LocalDate date = LocalDate.of(2000, Month.OCTOBER, 15);
		DayOfWeek dotw = date.getDayOfWeek();
		System.out.printf("%s is on a %s%n", date, dotw);

		System.out.printf("first day of Month: %s%n",
		                  date.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.printf("first Monday of Month: %s%n",
		                  date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
		System.out.printf("last day of Month: %s%n",
		                  date.with(TemporalAdjusters.lastDayOfMonth()));
		System.out.printf("first day of next Month: %s%n",
		                  date.with(TemporalAdjusters.firstDayOfNextMonth()));
		System.out.printf("first day of next Year: %s%n",
		                  date.with(TemporalAdjusters.firstDayOfNextYear()));
		System.out.printf("first day of Year: %s%n",
		                  date.with(TemporalAdjusters.firstDayOfYear()));
	}
	
	@Test
	public void customTest() {
//		Given the date:  2013 6 3
//		the next payday: 2013 6 14
		LocalDate date1 = LocalDate.of(2013, 6, 3);
		System.out.println(date1.with(new PaydayAdjuster()));
		
//		Given the date:  2013 6 18
//		the next payday: 2013 6 28
		LocalDate date2 = LocalDate.of(2013, 6, 18);
		System.out.println(date2.with(new PaydayAdjuster()));
	}
	
	static class PaydayAdjuster implements TemporalAdjuster {

		@Override
		public Temporal adjustInto(Temporal input) {
			LocalDate date = LocalDate.from(input);
		    int day;
		    if (date.getDayOfMonth() < 15) {
		        day = 15;
		    } else {
		        day = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
		    }
		    date = date.withDayOfMonth(day);
		    if (date.getDayOfWeek() == DayOfWeek.SATURDAY ||
		        date.getDayOfWeek() == DayOfWeek.SUNDAY) {
		        date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
		    }

		    return input.with(date);
		}
		
	}
}
