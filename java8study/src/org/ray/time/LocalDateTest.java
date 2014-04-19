package org.ray.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import org.junit.Test;

public class LocalDateTest {

	@Test
	public void test() {
		LocalDate date = LocalDate.of(2014, Month.APRIL, 1);
		LocalDate nextMonday = date.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(Locale.getDefault());
		System.out.println(date + " " + date.getDayOfWeek());
		System.out.println("是否是闰年：" + (date.isLeapYear() ? "是" : "不是" ));
		System.out.println("季度是：" + date.get(IsoFields.QUARTER_OF_YEAR));
		System.out.println("接下来的星期日：" + nextMonday);
		
		
	}
	
}
