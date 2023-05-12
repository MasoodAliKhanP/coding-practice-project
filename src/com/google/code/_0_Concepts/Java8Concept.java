package com.google.code._0_Concepts;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


class Employee implements Comparable<Employee>{
	int id;
	String title;
	Instant timeOfJoining;

	public Instant getTimeOfJoining() {
		return timeOfJoining;
	}
	public void setTimeOfJoining(Instant timeOfJoining) {
		this.timeOfJoining = timeOfJoining;
	}
	public Employee(int id, String title) {
		this.id = id;
		this.title = title;
	}
	public Employee(int id, String title,  Instant timeOfJoining) {
		this.id = id;
		this.title = title;
		this.timeOfJoining = timeOfJoining;
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
		return "Employee [id=" + id + ", title=" + title + ", timeOfJoining=" + timeOfJoining + "]";
	}
	@Override
	public int compareTo(Employee employee) {
		 return (int)(this.id - employee.getId());
	}
	
}

public class Java8Concept {
	private static final int WEEK_SECONDS = 7 * 24* 60 * 60;
	private static final int DAY_SECONDS = 24*60*60;
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
		hashMapGroupByJobTitle(employeeList);
		hashMapGroupByUsingComputeIf(employeeList);
		hashMapIterateUsingLambda();
//		priorityQueueExample();	
//		minMax();
//		instantDateExample();
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

		//map - total number of letters in all the names with more than 5 letters
		List<String> strList = Stream.of("one", "two", "three").collect(Collectors.toList());
		int totalLetters = strList.stream().filter(s -> s.length()>5).mapToInt(s -> s.length()).sum();
		
		//list of length of each string
		int[] strLengths = strList.stream().mapToInt(s->s.length()).toArray();
//		List<Integer> length =  strList.stream().map(String::length);
		
		//touppercase
		List<String> toUCase = strList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
		
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

	private static void hashMapGroupByJobTitle(List<Employee> employeeList) {
		Map<String, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getTitle));
		System.out.println("employee jobs: \n" + map);
		
		//partitioning people by adult and non adult, reutrn map<Boolean, List<People>>
//		people.stream() // Convert collection to Stream
//        .collect(partitioningBy(p -> p.getAge() >= 18));
	}
	
	private static void hashMapGroupByUsingComputeIf(List<Employee> employeeList) {
		Map<String, List<Integer>> resultMap = new HashMap<>();
		employeeList.stream().forEach(emp -> {
			resultMap
			.computeIfAbsent(emp.getTitle(), k -> new ArrayList<>())
			.add(emp.getId());
		});
		System.out.println("using computeifabsent: \n" + resultMap);
	}
	
	private static void hashMapIterateUsingLambda() {
		System.out.println("Iterate hash Map: ");
		Map<Character, Integer> cMap = new HashMap<>();
		String str = "abbcaa";
		for(Character c : str.toCharArray()) {
			cMap.put(c, cMap.getOrDefault(c, 0)+1);
//			cMap.put(c, cMap.computeIfAbsent(c, v -> 0) + 1);
		}
		cMap.forEach((k, v) -> {
			System.out.println("key: " + k + " value: " + v);

		});
	}
	
	private static void hashMapSorting(Map<String, Employee> map) {
		//toprint 
		map.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByKey())
		  .forEach(System.out::println);
		
		map.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue())
		  .forEach(System.out::println);
		
		//tostore
		Map<String, Employee> result = map.entrySet()
				  .stream()
				  .sorted(Map.Entry.comparingByValue())
				  .collect(Collectors.toMap(
				    Map.Entry::getKey, 
				    Map.Entry::getValue, 
				    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		 Map<String, Integer> unsortMap = new HashMap<>();
	        unsortMap.put("z", 10);
	        unsortMap.put("b", 5);
	        unsortMap.put("a", 6);
	        unsortMap.put("c", 20);
	        
	        Map<String, Integer> resultSorted = unsortMap.entrySet().stream()
	                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

	}
	private static void priorityQueueExample() {
		//default min heap
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(2); pq.add(10);pq.add(20);
//		pq.forEach(e -> System.out.println(e));
		
		PriorityQueue<Integer> pqInteger = new PriorityQueue<>((a,b)->b-a);//or (a,b) -> Integer.compare(a,b)
		pqInteger.add(2);pqInteger.add(20);pqInteger.add(10);
//		pqMax.forEach(e -> System.out.println(e));
		
		Comparator<Employee> byId = 
				(Employee e1, Employee e2)->Integer.compare(e2.getId(), e1.getId());
		PriorityQueue<Employee> pqEmployee = new PriorityQueue<>(byId);//or (a,b) -> Integer.compare(a,b)
		Employee em1 = new Employee(1, "ceo");
		Employee em2 = new Employee(2, "manager");
		Employee em3 = new Employee(3, "manager");
		pqEmployee.add(em1);pqEmployee.add(em2);pqEmployee.add(em3);
		
		pqEmployee.forEach(e -> System.out.println(e));
	}
	
	private static void minMax() {
		Comparator<Integer> integerCom = Comparator.comparing(Integer::valueOf);
		Comparator<Integer> integerCom2 = (i, j) -> Integer.compare(i, j);
		
		Integer maxNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
		          .max(integerCom2)
		          .get();
		 
		Integer minNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
		          .min(Comparator.comparing(Integer::valueOf))
		          .get();
		
		System.out.println("min: " + minNumber );
		System.out.println("max: " + maxNumber);
		
		ArrayList<Employee> eList = new ArrayList<>();
		Employee em1 = new Employee(1, "ceo", Instant.now().minusSeconds(DAY_SECONDS));
		Employee em2 = new Employee(2, "manager", Instant.now().minusSeconds(2*DAY_SECONDS));
		Employee em3 = new Employee(3, "manager", Instant.now().minusSeconds(3* DAY_SECONDS));
		eList.add(em1);eList.add(em2);eList.add(em3);
		
		Comparator<Employee> comparator = Comparator.comparing(Employee::getId);	
		Comparator<Employee> comparatorTitle = (Employee e1, Employee e2) -> e1.getTitle().compareTo(e1.getTitle());
		
		Employee minObject = eList.stream().min(comparator).get();
		System.out.println("Min id employee: " + minObject);
	}
	
	private static void instantDateExample() {
		ArrayList<Employee> eList = new ArrayList<>();
		Employee em1 = new Employee(1, "ceo", Instant.now().minusSeconds(DAY_SECONDS));
		Employee em2 = new Employee(2, "manager", Instant.now().minusSeconds(2*DAY_SECONDS));
		Employee em3 = new Employee(3, "manager", Instant.now().minusSeconds(3* DAY_SECONDS));
		eList.add(em1);eList.add(em2);eList.add(em3);

		Instant instant = Instant.now();
		List<Employee> filteredEList = eList.stream()
				.filter(e -> e.getTimeOfJoining().isAfter(instant.minusSeconds(2*DAY_SECONDS+1))).collect(Collectors.toList());
		System.out.println(filteredEList);
	}
	
	private static void flatMapExample() {
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);
  
        List<List<Integer>> Ints2dList =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
  
		List<Integer> arrList = Ints2dList.stream()
										.flatMap(list->list.stream())
										.collect(Collectors.toList());
		
		 String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
		 String[] result = Stream.of(array)  // Stream<String[]>
		          .flatMap(Stream::of)        // Stream<String>
		          .toArray(String[]::new);  
	}
	
	private static void optionalPractice() {
		//Optional can help to reduce the number of null pointer exceptions in your code
		//or example, a method that looks up a user by ID might not find a match, 
		//in which case it would return an empty Optional.
		
//		 the Optional class includes methods to explicitly deal with the cases where a value is present or absent. 
//		 However, the advantage compared to null references is that the Optional class forces you to 
//		 think about the case when the value is not present.
		
		Optional<String> opt = Optional.of("java8");
		if(opt.isPresent()) {
			System.out.println(opt.get());
		}
		
		opt.ifPresent(n -> System.out.println(n.length()));
		
		
		//in case of null value
		String nullName = null;
	    String name = Optional.ofNullable(nullName).orElse("john");
	    String nameGet = Optional.ofNullable(nullName).orElseGet(()->"john2");
	    System.out.println("john: " + name + "| john2: " + nameGet);

		
	}
	
}
