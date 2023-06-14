package com.google.code._0_Concepts;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

//lambda expressions
//parameter -> expression
//(parameter1, parameter2) -> expression
//(parameter1, parameter2) -> { code block }
// () -> "hello world!"

//Lambda expressions can be stored in variables if the variable's type is an interface which 
//has only one method. The lambda expression should have the same number of parameters 
//and the same return type as that method. Java has many of these kinds of interfaces built in, 
//such as the Consumer interface 
interface StringFunction {
	String run(String str);
}

public class Java8lambdaExpression {
	public static void main(String[] args) {
		// 1.
		Consumer<String> consumer = n -> {
			System.out.println(n);
		};
		consumer.accept("hello");

		// 2.
		Function<String, Integer> funct = str -> str.length();
		System.out.println(funct.apply("masood"));

		// 3.
		StringFunction sf = s -> s + "!";
		System.out.println(sf.run("world"));
		
		//4.
		Supplier<String> sup = () -> "hello world!";
		System.out.println(sup.get());
	}
}
