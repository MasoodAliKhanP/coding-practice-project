package com.google.code._0_Concepts;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//java.util.function package provides a set of re-usable common functional interfaces
//( and their corresponding lambda) definitions which can be used by the programmers in their 
//code instead of creating brand new functional interfaces.

//Functional interfaces provide target types for lambda expressions and method references. 
//Each functional interface has a single abstract method, called the functional method for 
//that functional interface.

//Any interface with a SAM(Single Abstract Method) is a functional interface, and its implementation may be treated as lambda expressions.

//java.util.function package contains lots of functional interfaces. Some of them are as follows:
//Function<T, R> :
//BiFunction<T, U, R>
//Consumer<T>
//BiConsumer<T>
//Predicate<T>
//BiPredicate<T, V>
//Supplier<T>

public class Java8FunctionalInterface {
	enum GENDER{
		MALE,FEMALE
	}
	public static void main(String[] args) {
		System.out.println("******** Functions **********");
		System.out.println("******** 1. Function<inputtype, outputtype> **********");
		Function<String, Integer> function = s -> s.length();
		System.out.println("str length: " + function.apply("masood"));

		System.out.println("******** 2. BiFunction<firstinputtype, secondinputtype, outputtype> **********");
		BiFunction<String, String, Integer> biFunction = (a, b) -> (a + b).length();
		System.out.println(biFunction.apply("hello", "world!"));

		System.out.println("******** 3. Consumer<inputtype> **********");
//		The Consumer Interface is a part of the java.util.function package. Represents an o
//		peration that accepts a single input argument and returns nothing.
		
//		Consumer can be used in all contexts where an object needs to be consumed, for instance 
//		taken as input, operation is to be performed without returning any result.
		Consumer<String> consumer = s -> {
			System.out.println(s);
		};
		consumer.accept("hello");
		
		System.out.println("******** 4. BiConsumer<firstinputtype, secondinputtype> **********");
		BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println(s1 + s2);
		biConsumer.accept("hello ", "BiConsumer!");
		
//		A function that accepts one argument and generates a boolean value as an answer is known 
//		as a predicate. A predicate functional interface of java is a type of function which 
//		accepts a single value or argument and does processing on it, and returns a boolean. 
		System.out.println("******** 5. Predicate<inputtype> **********");
		Predicate<String> isValidPredicate = phone -> {
			if(phone.startsWith("+91")) {
				return true;
			}
			return false;
		};
		System.out.println(isValidPredicate.test("+91-8300383020"));
		
		System.out.println("******** 6. BiPredicate<inputtype> **********");
		BiPredicate<String, String> isValidBiPred= 
                (phone, country) -> {
            if (country.equals("India") 
                    && phone.startsWith("+91")) {
                return true;
            }
            return false;
        };
        System.out.println(isValidBiPred.test("+91-8573948749", "India"));
        
		System.out.println("******** 7. Supplier<outputType> **********");
//		Suppliers are useful when we don’t need to supply any value and obtain a result at 
//		the same time.
		Supplier<String> supplier = () -> "Gender is : " + GENDER.MALE;
		System.out.println(supplier.get());
	}
}
