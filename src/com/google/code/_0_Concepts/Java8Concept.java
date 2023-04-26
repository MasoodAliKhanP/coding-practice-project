package com.google.code._0_Concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.Collectors;


class Product {
	int id;
	String name;

	Product(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}


class Employee {
	int id;
	String title;

	public Employee(int id, String title) {
		this.id = id;
		this.title = title;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", title=" + title + "]";
	}
	
}

public class Java8Concept {
	public static void main(String[] args) {
//		java8GettingStarted();
//		practice();
		List<Employee> employeeList = new ArrayList<>();
		Employee e1 = new Employee(1, "ceo");
		Employee e2 = new Employee(2, "manager");
		Employee e3 = new Employee(3, "manager");
		Employee e4 = new Employee(4, "mts");
		employeeList.add(e1);employeeList.add(e2);employeeList.add(e3); employeeList.add(e4);
//		practiceHashMap(employeeList);
//		groupByJobTitle(employeeList);
//		iterateUsingLambda();
		priorityQueueExample();
	}

	private static void java8GettingStarted() {
		// Basic Operations
		// Intermediate Ops
		// Intermediate operations are lazy. This means that they will be invoked only
		// if it is
		// necessary for the terminal operation execution.
		// 1.Map
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> sqList = list.stream().map(s -> s * s).collect(Collectors.toList());
		sqList.forEach(s -> System.out.print(s + " "));
		System.out.println();

		List<Product> productList = Arrays.asList(new Product(23, "potatoes"), new Product(14, "orange"),
				new Product(13, "lemon"), new Product(23, "bread"), new Product(13, "sugar"));
		List<String> proNames = productList.stream().map(p -> p.getName()).collect(Collectors.toList());
		proNames.forEach(n -> System.out.println(n));

		// toMap
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(i -> i.toString(), i -> i * i));
		System.out.println(map);

		// flatmap to convert 2d array to 1d

		// 2.filter
		List<String> names = Arrays.asList("Masood", "Afzal", "Muzafar", "Nabi");
		List<String> mNames = names.stream().filter(s -> s.startsWith("M")).collect(Collectors.toList());
		mNames.forEach(s -> System.out.println(s));

		// 3.sorted
		List<String> blist = Arrays.asList("Reflection", "Collection", "Stream");
		List<String> newBList = blist.stream().sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
		newBList.forEach(s -> System.out.println(s));

		// Terminal Ops
		// 4.collect
		// 5.forEach
		// 6.reduce
		list = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> even = list.stream().filter(x -> x % 2 == 0).reduce((a, b) -> a + b);
		System.out.println(even.get());
		Integer even2 = list.stream().filter(x -> x % 2 == 0).reduce(0, (a, b) -> a + b);
		System.out.println(even2);

		// getcount
		list = Arrays.asList(1, 2, 3, 4, 5);
		long count = (int) list.stream().filter(x -> x % 2 == 0).count();
		System.out.println(count);
	}

	private static void practice() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 6);
		List<Integer> newList = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println("new list: " + newList);

		//reduce
		Optional<Integer> reducedNum = list.stream().reduce((a, b) -> a + b);
		System.out.println("reduced sum: " + reducedNum.get());

		//alternate ways
		int mSum = list.stream().mapToInt(i -> i).sum();
		System.out.println("mSum: " + mSum);

		long count = list.stream().count();
		System.out.println("count: " + count);

		List<Product> productList = Arrays.asList(new Product(23, "potatoes"), new Product(14, "orange"),
				new Product(13, "lemon"), new Product(23, "bread"), new Product(13, "sugar"));
		int psum = productList.stream().mapToInt(p -> p.getId()).sum();
		System.out.println("pSum: " + psum);
	}

	private static void practiceHashMap(List<Employee> employeeList) {
		// traditional way
		Map<String, List<Employee>> resultMap = new HashMap<>();
		for (int i = 0; i < employeeList.size(); i++) {
			Employee employee = employeeList.get(i);
			List<Employee> employeeSubList = resultMap.getOrDefault(employee.getTitle(), new ArrayList<Employee>());
			employeeSubList.add(employee);
			resultMap.put(employee.getTitle(), employeeSubList);
		}
		System.out.println("map group: " + resultMap);
	}

	private static void groupByJobTitle(List<Employee> employeeList) {
		Map<String, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getTitle));
		System.out.println("employee jobs" + map);
	}
	
	private static void iterateUsingLambda() {
		Map<Character, Integer> cMap = new HashMap<>();
		String str = "abbcaa";
		for(Character c : str.toCharArray()) {
			cMap.put(c, cMap.getOrDefault(c, 0)+1);
		}
	    cMap.forEach((k, v) -> {
		    	if(v >2) {
		    		System.out.println(k);
		    	}
		    }	
	    );
	}
	
	private static void priorityQueueExample() {
		//default min heap
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(2); pq.add(10);pq.add(20);
//		pq.forEach(e -> System.out.println(e));
		
		PriorityQueue<Integer> pqMax = new PriorityQueue<>((a,b)->b-a);//or (a,b) -> Integer.compare(a,b)
		pqMax.add(2);pqMax.add(20);pqMax.add(10);
//		pqMax.forEach(e -> System.out.println(e));
		
		
		Employee em1 = new Employee(1, "ceo");
		Employee em2 = new Employee(2, "manager");
		Employee em3 = new Employee(3, "manager");
		Comparator<Employee> byId = 
				(Employee e1, Employee e2)->Integer.compare(e2.getId(), e1.getId());
		PriorityQueue<Employee> pqMax2 = new PriorityQueue<>(byId);//or (a,b) -> Integer.compare(a,b)
		pqMax2.add(em1);pqMax2.add(em2);pqMax2.add(em3);
		pqMax2.forEach(e -> System.out.println(e));
	}
}
