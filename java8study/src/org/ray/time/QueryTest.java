package org.ray.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;

import org.junit.Test;

public class QueryTest {

	@Test
	public void test() {
		TemporalQuery<TemporalUnit> query = TemporalQueries.precision();
		System.out.printf("LocalDate precision is %s%n",
                LocalDate.now().query(query));
		System.out.printf("LocalDateTime precision is %s%n",
		                LocalDateTime.now().query(query));
		System.out.printf("Year precision is %s%n",
		                Year.now().query(query));
		System.out.printf("YearMonth precision is %s%n",
		                YearMonth.now().query(query));
		System.out.printf("Instant precision is %s%n",
		                Instant.now().query(query));
	}
	
	@Test
	public void customTest() {
		LocalDate date = LocalDate.now();
		System.out.printf("%s\n", date);
		System.out.printf("is FamilyVacations: %s\n", date.query(new FamilyVacations()));
		System.out.printf("is FamilyBirthday: %s\n", date.query(QueryTest::isFamilyBirthday));
	}
	
	static class FamilyVacations implements TemporalQuery<Boolean> {

		@Override
		public Boolean queryFrom(TemporalAccessor date) {
			 int month = date.get(ChronoField.MONTH_OF_YEAR);
		    int day   = date.get(ChronoField.DAY_OF_MONTH);

		    // Disneyland over Spring Break
		    if ((month == Month.APRIL.getValue()) && ((day >= 3) && (day <= 8)))
		        return Boolean.TRUE;

		    // Smith family reunion on Lake Saugatuck
		    if ((month == Month.AUGUST.getValue()) && ((day >= 8) && (day <= 14)))
		        return Boolean.TRUE;

		    return Boolean.FALSE;
		}
		
	}
	
	public static Boolean isFamilyBirthday(TemporalAccessor date) {
	    int month = date.get(ChronoField.MONTH_OF_YEAR);
	    int day   = date.get(ChronoField.DAY_OF_MONTH);

	    // Angie's birthday is on April 3.
	    if ((month == Month.APRIL.getValue()) && (day == 3))
	        return Boolean.TRUE;

	    // Sue's birthday is on June 18.
	    if ((month == Month.JUNE.getValue()) && (day == 18))
	        return Boolean.TRUE;

	    // Joe's birthday is on May 29.
	    if ((month == Month.MAY.getValue()) && (day == 29))
	        return Boolean.TRUE;

	    return Boolean.FALSE;
	}
}
