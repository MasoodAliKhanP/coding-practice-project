package com.google.code._1_MathProblems;

import java.util.Arrays;

public class MathProblems {
	public static void main(String[] args) {
		generatePrimeNumbers();
		System.out.println();
		sieveMethod();
	}
	
	//square root method - if there is no number less than sqrt(n) divisible
	//then no other number beyond sqrt(n) is divisible
	private static void generatePrimeNumbers() {
		int N = 100;
		for(int i = 1; i <= N; i++) {
			if(isPrime(i)) {
				System.out.print(i + " ");
			}
		}
			
	}
	
	private static boolean isPrime(int n) {
		if(n==0 ||n==1)
			return false;
		for(int i = 2; i<= Math.sqrt(n); i++) {
			if(n%i == 0) {
				return false;
			}
		}	
		return true;
	}
	
	
	private static void sieveMethod() {
		int N = 100;
		boolean[] isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		for(int p = 2; p < Math.sqrt(N); p++) {
			if(isPrime[p]) {
				for(int j = p*p; j <= N; j+=p) {
					isPrime[j] = false;
				}
			}	
		}
		
		for(int i =2; i <= N; i++){
			if(isPrime[i]) {
				System.out.print(i + " ");
			}
		}

		
		
	}
	
	
	
	
	
	
	
	
	
	
}
