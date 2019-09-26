package com.ds.linkedlist;

public class LinkedList {
	Node head;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	void addToFront(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	int size() {
		Node current = head;
		int len = 0;
		while (current != null) {
			current = current.next;
			len++;
		}
		return len;
	}
/***  
 * if a fast moving node pointer has reference back  
 * with slow moving node pointer reference
 ***/
	boolean iscyclic() {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			
			// if a fast moving node pointer has reference back  
			// with slow moving node pointer reference
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
	int sizeOfCyclicLoop() {
		int len=0;
		if(iscyclic()) {
			Node fast = head;
			Node slow = head;
			
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				len ++;
				if (fast == slow) {
					return len;
				}
			} 
		} return len;
	}
	
	/**
	 * if the size of list is ODD, finding middle is okay
	 * but if it is EVEN then one of the two will be returned 
	 **/
	Node middleOfLinkedList() {
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == null || fast.next == null) {
				return slow;
			}
		}
		return null;
	}

	void printList() {
		Node current = head;
		System.out.print("Read -> ");
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println(" Null");
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addToFront(2);
		list.addToFront(6);
		list.addToFront(7);
		list.addToFront(4);
		list.addToFront(8);
		list.addToFront(9);
		list.addToFront(3);
		list.addToFront(5);
		list.addToFront(1);

		/************* To check if it is circular linked list ****
		 * 														 
		 * creating a circular linked list						 
		 * list.head.next.next.next.next=(list.head.next); 		 
		 * System.out.println("is cyclic "+ list.iscyclic());	 
		 * System.out.println("length of loop :"+list.sizeOfCyclicLoop());														 *
		 *********************************************************/
		
		list.printList();
		System.out.println(list.size());
		System.out.println(list.middleOfLinkedList().data);
	}

}
