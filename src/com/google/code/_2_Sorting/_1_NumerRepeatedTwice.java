package com.google.code._2_Sorting;

public class _1_NumerRepeatedTwice {
	public static void main(String[] args) {
//		System.out.println("Main");
//		int[] arr = {1, 1, 4, 4, 5};
		int[] arr = {1, 4, 4, 5, 5};
//		int[] arr = {1, 1, 4, 4, 5, 6, 6}; //[0...6]
//		int[] arr = {1, 1, 4, 5, 5, 6, 6};
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		System.out.println(getNonRepeatedElement(arr));
	}
	
	
	private static int getNonRepeatedElement(int[] arr) {
		int l = 0;
		int r = arr.length-1 ;
		int mid;
		
		while(l <= r) {
			mid = l + (r-l)/2;
			
			if(mid == arr.length -1 || mid == 0) {
				return arr[mid];
			}

			if((arr[mid] != arr[mid+1]) && (arr[mid] != arr[mid-1])) {
				return arr[mid];
			}

			if(arr[mid] == arr[mid+1]){
				if((r-mid)%2 == 0) {
					l = mid;
				}else {
					r = mid - 1;
				}
			}else {
				if((mid-l)%2 == 0) {
					r = mid;
				}else {
					l = mid + 1;
				}
			}
			
			
		}
		
		return 0;
	}
}
