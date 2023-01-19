package com.google.code._91_Heaps;

import java.util.Arrays;

public class HeapConstruction {
	
	static void heapify(int arr[], int n, int parentIndex) {
		int lcIndex = 2 * parentIndex + 1;
		int rcIndex = 2 * parentIndex + 2;

		int maxEleIndex = parentIndex;
		if (lcIndex < n && arr[lcIndex] > arr[maxEleIndex]) {
			maxEleIndex = lcIndex;
		}
		if (rcIndex < n && arr[rcIndex] > arr[maxEleIndex]) {
			maxEleIndex = rcIndex;
		}

		if (maxEleIndex != parentIndex) {//imp to avoid infinite loop
			swap(arr, parentIndex, maxEleIndex);
			heapify(arr, n, maxEleIndex);
		}
	}

	static void buildHeap(int arr[], int n) {
		int lastParentIndex = n / 2 - 1;
		for (int i = lastParentIndex; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}

	static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void heapSort(int a[], int n) {
		for(int i=n-1; i > 0; i--) {
			System.out.print(a[0] + " ");
			swap(a, 0, i);
			heapify(a, i, 0);
		}
		System.out.print(a[0] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[] = { 15, 17 , 1, 3, 5, 4, 6, 13, 10, 9, 8, 2, 7};
		int n = arr.length;
		System.out.println("Before: " + Arrays.toString(arr));
		buildHeap(arr, n);
		System.out.println("After Heap: " + Arrays.toString(arr));
		
		heapSort(arr,n);
		System.out.println("After Sort: " + Arrays.toString(arr));

	}
}
