package org.ray.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.ray.lambda.entity.Person;
import org.ray.lambda.filter.CheckPerson;
import org.ray.lambda.filter.Criteria;

public class Test {

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

	public static void printPersonsOlderThan(List<Person> roster, int age) {
	    printPersons(roster, (Person p) -> p.getAge() > age);
	}
	
	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}
	
	public static void printPersonWithCriteria(List<Person> roster, Criteria<Person> c) {
		for (Person p : roster) {
			if (c.search(p)) {
				p.printPerson();
			}
		}
	}

	public static void processPersons(List<Person> roster, Criteria<Person> c, Consumer<Person> block) {
		for (Person p : roster) {
			if (c.search(p)) {
				block.accept(p);
			}
		}
	}
	
	public static void processPersonsWithFunction(List<Person> roster, Criteria<Person> c, Function<Person, String> mapper, Consumer<String> block) {
		for (Person p : roster) {
			if (c.search(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
	
	public static <X, Y> void processElements(Iterable<X> iterable, Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> block) {
		for (X x : iterable) {
			if (tester.test(x)) {
				Y data = mapper.apply(x);
				block.accept(data);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("\nprocessPersons  ---");
		processPersons(roster, 
				p -> p.getName().equals("ray"), 
				p -> p.printPerson());
		
		System.out.println("\nprocessPersonsWithFunction ---");
		processPersonsWithFunction(roster, 
				p -> p.getAge() >= 18, 
				p -> p.getEmailAddress(), 
				email -> System.out.println(email));
		
		System.out.println("\nprocessElements ---");
		processElements(roster, 
				p -> p.getAge() >= 18, 
				p -> p.getEmailAddress(), 
				email -> System.out.println(email));
		
		System.out.println("\nAggregate Operations");
		roster.stream()
			.filter(p -> p.getEmailAddress().indexOf("@") != -1)
			.map(p -> p.getName())
			.forEach(name -> System.out.println(name));
	}
	
}
