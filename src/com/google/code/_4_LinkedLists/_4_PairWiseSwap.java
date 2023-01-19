package com.google.code._4_LinkedLists;

public class _4_PairWiseSwap {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private static void swap(Node node, Node nNode) {
		int temp = node.data;
		node.data = node.next.data;
		node.next.data = temp;
	}

	private static void swapPairWise(Node node) {
		if (node != null && node.next != null) {
			swap(node, node.next);
			swapPairWise(node.next.next);
		}
	}
	
	private static void printList(Node node) {
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node n1 = new Node(4);
		Node n2 = new Node(9);
		Node n3 = new Node(14);
		Node n4 = new Node(10);
		Node n5 = new Node(15);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		System.out.println("Linked List before calling pairWiseSwap() ");
		printList(n1);

		swapPairWise(n1);

		printList(n1);
	}
}
