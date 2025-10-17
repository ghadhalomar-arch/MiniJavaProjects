/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ;

/**
 *
 * @author ghadh
 */

public class CircularlyLinkedList<T> {
	private Node<T> tail;
	private Node<T> curr;
	
	private int size; // 0
	
	public CircularlyLinkedList() {

	}
	
	// helper
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size ==  0;
	}
	
	// first , last
	public T first() {
		if(isEmpty())
			return null;
		
		return tail.getNext().getData();
	}
	
	public T last() {
		if(isEmpty())
			return null;
		
		return tail.getData();
	}
	
	public void rotate() {
		if(tail != null)
			tail = tail.getNext();
	}
	
	// addFirst
	public void addFirst(T elem) {
		Node<T> n = new Node(elem);
		
		// empty
		if(isEmpty()) {
			tail = n;
			tail.setNext(tail);
		}else {
			n.setNext(tail.getNext());
			tail.setNext(n);
		}
		
		size++;
	}
	
	// addLast
	public void addLast(T elem) {
		addFirst(elem);
		tail = tail.getNext();
	}
	
	// reomveFirst
	public T removeFirst() {
		if(isEmpty()) 
			return null;
		
		Node<T> n = tail.getNext();
		
		if(size == 1) {
			tail = null;
		}else {
			tail.setNext(tail.getNext().getNext());
		}
		size--;
		return n.getData();
	}
	
	//print CLL
	public void print() {
		if(tail == null) 
			return;
		
		// one Data:
		if(size == 1) {
			System.out.println(tail.getData());
			return;
		}
		
		// many data:
//		curr = tail.getNext();
//		do {
//			System.out.print(curr.getData()+" -> ");
//			curr = curr.getNext();
//		}while(curr != tail.getNext());
		
		for(int i =0 ; i < size ; i++) {
			rotate();
			System.out.print(tail.getData()+" -> ");
		}

	}
	
	public void search(T elem) {
		boolean isFound = false;
		for(int i = 0 ; i < size ; i++) {
			rotate();
			if(elem == tail.getData()) {
				isFound = true;
			}
		}
		
		if(isFound == true)
			System.out.println("the: "+elem+" is exists");
		else
			System.out.println("the: "+elem+" is not exists");
	}
}