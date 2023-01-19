package com.google.code._4_LinkedLists;



//ip: 1->5->4->2->7->8
//op: 4->2->8->1->5->7
public class _5_SegregateOddEven {
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

	private static void segregateOddEven(Node node) {
		//Easiest way is to use 2 seperate lists/queue to store odd/even data Nodes then move them to a single queue
		//then reconstruct list
		//this adds to aux space O(n)
		
		
		//Need to check for another solution.
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

		segregateOddEven(n1);

		printList(n1);
	}
}
