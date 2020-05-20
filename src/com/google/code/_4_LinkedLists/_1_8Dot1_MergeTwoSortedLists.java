package com.google.code._4_LinkedLists;

class Node<T> {
    public T data;
    public Node<T> next;

    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}

public class _1_8Dot1_MergeTwoSortedLists {
    public static void main(String args[]) {

        Node<Integer> n1 = new Node<>(4, null);
        Node<Integer> n2 = new Node<>(9, null);
        Node<Integer> n3 = new Node<>(14, null);
        Node<Integer> n4 = new Node<>(6, null);
        Node<Integer> n5 = new Node<>(7, null);

        n1.next = n2;
        n2.next = n3;

        n4.next = n5;

        Node<Integer> L1 = new Node<>(3, null); // 3->4->9->14
        L1.next = n1;
//        printLinkedList(L1);

        Node<Integer> L2 = new Node<>(6, null);// 6->7->6
        L2.next = n4;
//        printLinkedList(L2);

        Node<Integer> head = mergeTwoSortedList(L1, L2);
        printLinkedList(head);
    }

    private static Node<Integer> mergeTwoSortedList(Node<Integer> L1, Node<Integer> L2) {

        Node<Integer> p1 = L1;
        Node<Integer> p2 = L2;
        Node<Integer> dummyHead = new Node<>(0, null);
        Node<Integer> current = dummyHead;

        while (p1 != null && p2 != null) {
            System.out.println("p1: " + p1.data + " p2: " + p2.data);
            if (p1.data <= p2.data) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }
        current.next = p1 != null ? p1 : p2;
        return dummyHead.next;
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
    }
}
