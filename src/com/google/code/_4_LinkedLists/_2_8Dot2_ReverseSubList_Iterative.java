package com.google.code._4_LinkedLists;

public class _2_8Dot2_ReverseSubList_Iterative {

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1, null);
        Node<Integer> node2 = new Node<>(2, null);
        Node<Integer> node3 = new Node<>(3, null);
        node1.next = node2;
        node2.next = node3;
        Node<Integer> reverseHead = reverseList(node1);
        Node<Integer> nodeIter = reverseHead;

        while (nodeIter != null) {
            System.out.print(nodeIter.data + "->");
            nodeIter = nodeIter.next;
        }
    }

    private static Node<Integer> reverseList(Node<Integer> head) {
        // 1->2->3
        Node<Integer> current = head;
        Node<Integer> prev = null;
        Node<Integer> next;
        while (current != null) {
            System.out.print(current.data + "->");
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        System.out.println();
        return prev;
    }

}
