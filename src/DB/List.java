/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import Model.Orders;

/**
 *
 * @author asanka
 */
public class List {
    
	class Node {
		private Orders data;
		private Node next;

		Node(Orders data) {
			this.data = data;
		}
	}

	private Node first;

	public boolean isEmpty() {
		return first == null;
	}

	public void add(int index, Orders data) {

		if (index >= 0 && index <= size()) {
			Node node = new Node(data);
			if (index == 0) {

				node.next = first;
				first = node;
				return;
			}
			Node current = first;
			int count = 0;
			while (count < index - 1) {
				count++;
				current = current.next;

			}
			node.next = current.next;
			current.next = node;
		}

	}

	public void add(Orders data) {
		Node node = new Node(data);
		if (isEmpty()) {
			first = node;
			return;
		}
		Node current = first;
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;

	}

	public void remove() {
		if (!isEmpty()) {
			if (first.next == null) {
				first = null;
			} else {
				Node current = first;
				Node previous = current;
				while (current.next != null) {
					previous = current;
					current = current.next;
				}
				previous.next = null;
			}
		} else {
			System.out.println("List is empty...");
		}
	}

	public Orders get(int index) {
		if (index >= 0 && index < size()) {
			Node current = first;
			int count = 0;
			while (count < index) {
				current = current.next;
				count++;
			}
			return current.data;
		}
		return null;

	}

	public void remove(int index) {
		if (index >= 0 && index < size()) {
			Node current = first;
			Node previous = current;
			int count = 0;
			while (count < index) {
				count++;
				previous = current;
				current = current.next;
			}
			if (index == 0) {
				first = first.next;
				return;
			} else if (index == size() - 1) {
				previous.next = null;
				return;
			}

			previous.next = current.next;
			current.next = null;
		}
	}

	public int size() {
		Node current = first;
		int count = 0;

		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void clear() {
		first = null;
	}

    
}
