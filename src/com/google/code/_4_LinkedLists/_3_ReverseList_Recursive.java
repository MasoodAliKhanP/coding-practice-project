package com.google.code._4_LinkedLists;

public class _3_ReverseList_Recursive {
	static Node head; // head of list

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}

		Node() {
			data = 0;
			next = null;
		}
	}

	static void push(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}

	static void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	static void print(Node rHead) {
		Node temp = rHead;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	static void reverseGlobalHead(Node current) {
		if (current == null) {
			return;
		}
		Node next = current.next;
		if (next == null) {
			head = current;
			return;
		}
		reverseGlobalHead(next);
		next.next = current;
		current.next = null;
	}

	//Solution 2 Not following Karumanchi
//	static void reverseKM(Node current, Node[] rHead) {
//		if (current == null) {
//			return;
//		}
//		Node next = current.next;
//		if (next == null) {
//			rHead[0] = current;
//			return;
//		}
//		reverseKM(next, rHead);
//		next.next = current;
//		current.next = null;
//	}

//	static Node reverseKM(Node current) {
//		if (current == null || current.next == null) {
//			return current;
//		}
//		Node next = current.next;
//		Node lhead = reverseKM(next);
//		next.next = current;
//		current.next = null;
//		return lhead;
//	}

	public static void main(String[] args) {
		push(4);
		push(3);
		push(2);
		push(1);

		System.out.println("Given linked list");
		print();

//		works as head is global
//		reverseKM(head);
//		print();

//		works beacuse of array
//		Node[] rHead = new Node[10];
//		reverseKM(head, rHead);
//		print(rHead[0]);

//		Node rHead = reverseKM(head);
		reverseGlobalHead(head);
		print(head);

	}
}
