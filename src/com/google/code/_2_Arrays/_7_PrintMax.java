package com.google.code._2_Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//Ip
//int[] A = { 20, 33, 11, 2 };
//int[] B = { 10, 30, 4, 2 };
//int[] C = { 1, 2, 32, 3 };
//OP: 20 33 11 10 30 4 2 2 1 2 32 3 

public class _7_PrintMax {

	private static ArrayList<Integer> converToArrayList(int[] arr) {
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			al.add(arr[i]);
		}
		return al;
	}

	private static class ANode {
		int data;
		int aIndex;

		public ANode(int data, int aIndex) {
			this.data = data;
			this.aIndex = aIndex;
		}

		public int getData() {
			return data;
		}

		public int getaIndex() {
			return aIndex;
		}
	}

	static class SortByData implements Comparator<ANode> {
		@Override
		public int compare(ANode a, ANode b) {
			return b.data - a.data;
		}
	}

	private static void getMaxElementFromFrontArray(ArrayList<ArrayList<Integer>> alList) {
		PriorityQueue<ANode> pq = new PriorityQueue<ANode>(new SortByData());
		pq.add(new ANode(alList.get(0).get(0), 0));
		pq.add(new ANode(alList.get(1).get(0), 1));
		pq.add(new ANode(alList.get(2).get(0), 2));

		while (!pq.isEmpty()) {
			ANode maxNode = pq.poll();
			System.out.print(maxNode.getData() + " ");

			alList.get(maxNode.getaIndex()).remove(0);
			if (!alList.get(maxNode.getaIndex()).isEmpty()) {
				ANode nextNode = new ANode(alList.get(maxNode.getaIndex()).get(0)
											, maxNode.getaIndex());
				pq.add(nextNode);
			}
		}
	}

	public static void main(String[] args) {
		int[] A = { 20, 33, 11, 2 };
		int[] B = { 10, 30, 4, 2 };
		int[] C = { 1, 2, 32, 3 };

		// Not right solution
		ArrayList<Integer> Al = converToArrayList(A);
		ArrayList<Integer> Bl = converToArrayList(B);
		ArrayList<Integer> Cl = converToArrayList(C);

		System.out.println(Al.toString() + Bl.toString() + Cl.toString());
		
		ArrayList<ArrayList<Integer>> alList = new ArrayList<ArrayList<Integer>>();
		alList.add(Al); alList.add(Bl); alList.add(Cl);
		
		getMaxElementFromFrontArray(alList);

	}

}
