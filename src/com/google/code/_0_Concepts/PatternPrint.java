package com.google.code._0_Concepts;

class PatternPrint {

	public static void main(String[] args) {

		int rows = 5;
		int colms = 5;
		int OddLineCntr = 1;
		int evenLineCntr = 9;

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= colms; j++) {
				if ((i % 2 == 1) && j <= colms) {
					System.out.print(OddLineCntr++ + " ");
				} else if (j <= colms) {
					System.out.print(evenLineCntr-- + " ");
				}
			}
			colms--;
			System.out.println();
		}
	}

//	public static void main(String[] args) {
//		int a = 1;
//		int b = 9;
//
//		for (int i = 5; i <= 5 && i >=1; i -= 2) {
//			for (int j = 1; j <= i; j++) {
//				System.out.print(a++ + " ");
//			}
//			System.out.println();
//			for (int k = 1; k < i; k++) {
//				System.out.print(b-- + " ");
//			}
//			System.out.println();
//			
//		}
//	}
}

//This code is contributed by Mukul Sharma
