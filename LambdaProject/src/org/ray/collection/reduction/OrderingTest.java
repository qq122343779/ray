package org.ray.collection.reduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class OrderingTest {

	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		
		System.out.println("No.1 added order");
		list.stream().forEach(e -> System.out.print(e + " "));
		
		System.out.println("\nNo.2 sorted");
		Comparator<Integer> normal = Integer::compare;
		Comparator<Integer> reversed = normal.reversed();
		Collections.sort(list, reversed);
		list.stream().forEach(e -> System.out.print(e + " "));
		
		System.out.println("\nNo.3 parallel");
		list.parallelStream().forEach(e -> System.out.print(e + " "));
		
		System.out.println("\nNo.4 another parallel");
		list.parallelStream().forEach(e -> System.out.print(e + " "));
		
		System.out.println("\nNo.5 parallel ordered");
		list.parallelStream().forEachOrdered(e -> System.out.print(e + " "));
	}
	
}
