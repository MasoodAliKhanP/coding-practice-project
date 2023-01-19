package com.google.code._2_Arrays;

public class _6_MajorityElement {
	public static void main(String[] args) {
		int[] arr = {2,2,3,1,2,2,1,2};
		findNby3Majority(arr);
		findNby2Majority(arr);
	}

//	O(Nlogk), space O(k)
	public static void findNby3Majority(int[] arr) {
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		int count1 = 0, count2 = 0;
		boolean found = false;
		
		for(int i = 0; i< arr.length; i++) {
			if(first == arr[i]) {
				count1++;
			}else if(second == arr[i]) {
				count2++;
			}else if(count1 == 0) {
				count1++;
				first = arr[i];
			}else if(count2 == 0){
				count2++;
				second = arr[i];
			}else {
				count1--;
				count2--;
			}
		}
		
		count1 = 0; count2 = 0;
		
		for(int i=0; i< arr.length; i++) {
			if(arr[i] == first) {
				count1++;
			}else if(arr[i] == second) {
				count2++;
			}
		}
		if(count1 > arr.length/3) {
			System.out.println(first);
			found = true;
		}
		if(count2 > arr.length/3) {
			System.out.println(second);
			found = true;
		}
		
		if(!found) {
			System.out.println("Not Found!");
		}
	}

	
	
	private static void findNby2Majority(int[] arr) {
		int count =1;
		int majority = Integer.MAX_VALUE, found = 0;
		for(int i = 0; i < arr.length; i++) {
			if(majority == arr[i]) {
				count++;
			}else {
				count--;
			}
			if(count==0) {
				count++;
				majority = arr[i]; 
			}
		}
		count=0;
		for(int i=0; i< arr.length; i++) {
			if(arr[i]==majority) count++;
		}
		if(count > arr.length/2) {
			System.out.println(majority);
			found = 1;
		}
		if(found == 0 ) {
			System.out.println("Not found!");
		}
	}
}
