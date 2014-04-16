package org.ray.collection.reduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.junit.Test;
import org.ray.lambda.entity.Person;

public class ReductionTest {

	static List<Person> roster = Person.createRoster();
	
	public static <T> void printCollection(Collection<T> collection) {
		collection.stream().forEach(e -> System.out.println(e));
	}
	
	@Test
	public void interference() {
		try {
			List<String> listOfStrings =
		        new ArrayList<>(Arrays.asList("one", "two"));
		         
		    // This will fail as the peek operation will attempt to add the
		    // string "three" to the source after the terminal operation has
		    // commenced. 
		             
		    String concatenatedString = listOfStrings
		        .stream()
		        
		        // Don't do this! Interference occurs here.
		        .peek(s -> listOfStrings.add("three"))
		        
		        .reduce((a, b) -> a + " " + b)
		        .get();
		                 
		    System.out.println("Concatenated string: " + concatenatedString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void sum() {
		// 第一种
		int sum = roster.stream().mapToInt(Person::getAge)
			.sum();
		
		System.out.println(sum);
		
		// 第二种
		sum = roster.stream().mapToInt(Person::getAge)
			.reduce(0, (a, b) -> a + b);
		
		System.out.println(sum);
	}
	
	@Test
	public void collect() {
		Averager avg = roster.stream()
			.filter(p -> p.getGender().equals(Person.Sex.MALE))
			.map(p -> p.getAge())
			.collect(Averager::new, Averager::accept, Averager::combine);
		System.out.println(avg.average());
		
		List<String> namesOfMaleMembersCollect = 
				roster.stream()
				.filter(p -> Person.Sex.FEMALE.equals(p.getGender()))
				.map(Person::getName)
				.collect(Collectors.toList());
		printCollection(namesOfMaleMembersCollect);
		
		Map<Person.Sex, List<String>> namesByGender = roster.stream().collect(
				Collectors.groupingBy(
						Person::getGender, Collectors.mapping(
								Person::getName, Collectors.toList())));
		System.out.println(namesByGender);
		
		Map<Person.Sex, Integer> totalAgesByGender = 
				roster.stream().collect(
						Collectors.groupingBy(
								Person::getGender, Collectors.reducing(
										0, Person::getAge, Integer::sum)));
		System.out.println(totalAgesByGender);
		
		Map<Person.Sex, Double> averageAgeByGender = 
			roster.stream().collect(
					Collectors.groupingBy(
							Person::getGender, Collectors.averagingInt(Person::getAge)));
		System.out.println(averageAgeByGender);
	}
	
	@Test
	public void parallel() {
		double avgAge = roster.parallelStream()
			.filter(p -> p.getGender().equals(Person.Sex.MALE))
			.mapToInt(Person::getAge)
			.average().getAsDouble();
		System.out.println(avgAge);
	}
	
	@Test
	public void concurrentReduction() {
		// normal way
		Map<Person.Sex, List<Person>> map = roster.stream()
				.collect(Collectors.groupingBy(Person::getGender));
		System.out.println(map);
		
		// parallel 
		ConcurrentMap<Person.Sex, List<Person>> concurrentMap = 
				roster.parallelStream()
				.collect(Collectors.groupingByConcurrent(Person::getGender));
		System.out.println(concurrentMap);
	}
}
