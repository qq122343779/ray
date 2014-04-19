package org.ray.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.ray.lambda.entity.Person;

public class MethodReferece {

	static List<Person> roster = new ArrayList<>();
	
	static {
		roster.add(new Person("ray", LocalDate.ofYearDay(1985, 1), Person.Sex.MALE, "ray@qq.com"));
		roster.add(new Person("xiaodan", LocalDate.ofYearDay(1990, 1), Person.Sex.FEMALE, "xiaodan@qq.com"));
		roster.add(new Person("tingjie", LocalDate.ofYearDay(1986, 1), Person.Sex.MALE, "tingjie@qq.com"));
	}
	
	public static void main(String[] args) {
		Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
		Arrays.sort(rosterAsArray, (a, b) -> Person.compareByAge(a, b));
		Arrays.sort(rosterAsArray, Person::compareByAge);
		
		Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
		List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
		    System.out.println("Sum of integers: " +
		        listOfIntegers
		            .stream()
		            .reduce(Integer::sum).get());
	}
}
