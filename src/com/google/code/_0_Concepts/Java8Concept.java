package com.google.code._0_Concepts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Product{
	int id;
	String name;
	Product(int id, String name){
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

public class Java8Concept {
	public static void main(String[] args) {
		//Basic Operations
		//Intermediate Ops
		//Intermediate operations are lazy. This means that they will be invoked only if it is 
		//necessary for the terminal operation execution.
		//1.Map
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		List<Integer> sqList = list.stream()
				.map(s -> s*s)
				.collect(Collectors.toList());
		sqList.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
				  new Product(14, "orange"), new Product(13, "lemon"),
				  new Product(23, "bread"), new Product(13, "sugar"));
		List<String> proNames = productList.stream()
				.map(p->p.getName())
				.collect(Collectors.toList());
		proNames.forEach(n -> System.out.println(n));
		
		
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(i->i.toString(), i->i));
		System.out.println(map);
		
		//flatmap to convert 2d array to 1d
		
		//2.filter
		List<String> names = Arrays.asList("Masood", "Afzal", "Muzafar", "Nabi");
		List<String> mNames = names.stream().filter(s->s.startsWith("M")).collect(Collectors.toList());
		mNames.forEach(s -> System.out.println(s));
		
		//3.sorted
		List<String> blist = Arrays.asList("Reflection","Collection","Stream");
		List<String> newBList = blist.stream().sorted((a,b)-> b.compareTo(a)).collect(Collectors.toList());
		newBList.forEach(s -> System.out.println(s));
		
		//Terminal Ops
		//4.collect
		//5.forEach
		//6.reduce
		 list = Arrays.asList(1,2,3,4,5);
		 Optional<Integer> even =
				 list.stream().filter(x->x%2==0).reduce((a,b)->a+b);
		 System.out.println(even.get());
		 Integer even2 =
				 list.stream().filter(x->x%2==0).reduce(0,(a,b)-> a+b);
		 System.out.println(even2);
		 
		 
		 //getcount
		 list = Arrays.asList(1,2,3,4,5);
		 long count = (int) list.stream().filter(x->x%2==0).count();
		 System.out.println(count);
	}
  
}
