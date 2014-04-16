package org.ray.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.ray.lambda.entity.Person;

public class AggregateTest {

	static List<Person> roster = new ArrayList<>();
	
	static {
		roster.add(new Person("ray", LocalDate.ofYearDay(1985, 1), Person.Sex.MALE, "ray@qq.com"));
		roster.add(new Person("xiaodan", LocalDate.ofYearDay(1990, 1), Person.Sex.FEMALE, "xiaodan@qq.com"));
		roster.add(new Person("tingjie", LocalDate.ofYearDay(1986, 1), Person.Sex.MALE, "tingjie@qq.com"));
		
		for (int i = 1; i <= 50; i++) {
			roster.add(new Person(
					"person" + i, 
					LocalDate.ofYearDay(1985, i), 
					Person.Sex.MALE, 
					"person@qq.com"));
		}
	}
	
	@org.junit.Test
	public void test() {
		double avg = roster.stream()
				.filter(p -> p.getName().indexOf("person") != -1)
				.mapToInt(Person::getAge)
				.average()
				.getAsDouble();
		System.out.println(avg);
	}
	
}
