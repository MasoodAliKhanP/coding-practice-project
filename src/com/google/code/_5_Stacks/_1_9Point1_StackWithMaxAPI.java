package com.google.code._5_Stacks;

import java.util.Deque;
import java.util.LinkedList;

class ElementWithCachedMax {
	Integer element;
	Integer max;

	public ElementWithCachedMax(Integer element, Integer max) {
		this.element = element;
		this.max = max;
	}
}

public class _1_9Point1_StackWithMaxAPI {

	// Stores (element , cached maximum) pair.
	private Deque<ElementWithCachedMax> elementWithCachedMax = new LinkedList<>();

	public boolean empty() {
		return elementWithCachedMax.isEmpty();
	}

	public Integer max() {
		if (empty()) {
			throw new IllegalStateException("max (): empty stack");
		}
		return elementWithCachedMax.peek().max;
	}

	public Integer pop() {
		if (empty()) {
			throw new IllegalStateException("pop (): empty stack");
		}
		return elementWithCachedMax.removeFirst().element;
	}

	public void push(Integer x) {
		Integer max = Math.max(x, empty() ? x : max());
		elementWithCachedMax.addFirst(new ElementWithCachedMax(x, max));
	}

	public static void main(String args[]) {
		_1_9Point1_StackWithMaxAPI stack = new _1_9Point1_StackWithMaxAPI();
		System.out.println("Stack");
		stack.push(0);
		stack.push(4);
		stack.push(8);
		stack.push(10);
		stack.push(3);

		System.out.println("Max: " + stack.max());
		while (!stack.empty()) {
			System.out.println("Pop:" + stack.pop());
			System.out.println("Max: " + stack.max());
		}
	}
}
