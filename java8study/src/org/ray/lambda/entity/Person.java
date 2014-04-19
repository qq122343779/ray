package org.ray.lambda.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {

	public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person() { }

	public Person(String name, LocalDate birthday) {
		this(name, birthday, Sex.MALE);
	}

	public Person(String name, LocalDate birthday, Sex gender) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
	}

	public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	public int getAge() {
    	return LocalDate.now().getYear() - this.birthday.getYear();
    }

	public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
	
	public static List<Person> createRoster() {
		List<Person> roster = new ArrayList<>();
		
		roster.add(new Person("ray", LocalDate.ofYearDay(1985, 1), Person.Sex.MALE, "ray@qq.com"));
		roster.add(new Person("xiaodan", LocalDate.ofYearDay(1990, 1), Person.Sex.FEMALE, "xiaodan@qq.com"));
		roster.add(new Person("xiaoxiaodan", LocalDate.ofYearDay(1995, 1), Person.Sex.FEMALE, "xiaodan@qq.com"));
		roster.add(new Person("tingjie", LocalDate.ofYearDay(1986, 1), Person.Sex.MALE, "tingjie@qq.com"));
		
		for (int i = 1; i <= 10; i++) {
			roster.add(new Person(
					"person" + i, 
					LocalDate.ofYearDay(1985, i), 
					Person.Sex.MALE, 
					"person@qq.com"));
		}
		
		return roster;
	}
    
    public void printPerson() {
        System.out.println(name);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
    
}
