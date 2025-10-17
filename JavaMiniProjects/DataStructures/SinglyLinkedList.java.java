/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ;

/**
 *
 * @author ghadh
 */
public class SinglyLinkedList<E> {
	private Node<E> head;// null
	private Node<E> tail;// null
	private Node<E> curr;

	private int size;// 0


	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}


	// big-O(1)
	public boolean isEmpty() {
		return size == 0;
	}

	// addFirst
	// empty , one data, many data

	// big-O(1)
	public void addFirst(E elem) {
		head = new Node<E>(elem , head);
		if(isEmpty()) {
			tail = head;
		}
		size++;
	}

	// addLast
	// cases: empty , one data, many data
	
	/*
	 *  addLast without tail
	 *  1- empty data
	 *  2- one data
	 *  3- many data
	 */
//	big-O(n)
//	public void addList(E elem) {
//		Node<E> n = new Node<E>(elem);
//		if(head == null) {
//			head = n;
//		}else if(size == 1) {
//			head.setNext(n);
//		}else {
//			Node<E> curr = head;
//			while(curr.getNext() != null) {
//				curr = curr.getNext();
//			}
//			curr.setNext(n);
//		}
//		size++;
//	}

	// big-O(1)
	public void addLast(E elem) {
		Node n = new Node(elem);

		if( isEmpty() ) {
			head = n;
			tail = n;
		}else if(size >= 1) {
			tail.setNext(n);
			tail = n;
		}
		size++;
	}

	// big-O(n)
	public void add(E elem, int index) {
		if(index < 0 || index > size) {
			System.out.println("out of bound!");
			return;
		}

		Node n = new Node(elem);
		if(isEmpty() ) {
			n.setNext(head);
			head = n;
		}else {
			Node curr = head;

			for(int i =0 ; i < index - 1 ; i++) {
				curr = curr.getNext();
			}

			n.setNext(curr.getNext());
			curr.setNext(n);

			if(curr == tail) {
				tail = curr.getNext();
			}
		}
		size++;
	}

	//removeFirst
	// cases: empty , one data, many data
	// big-O(1)
	public E removeFirst() {
		if(isEmpty())// empty
			return null;


		//		T n = head.getData();
		Node<E> n = head;

		// one data
		if(size == 1) 
			head = tail = null;
		else
			head = head.getNext();

		size--;

		return n.getData();
	}

	// removeLast
	// cases: empty , one data, many data
	// big-O(n)
	public E removeLast() {
		//empty
		if(isEmpty())
			return null;

		Node<E> n = tail;
		if(size == 1)
			head = tail = null;
		else{
			Node<E> curr = head;
			while(curr.getNext() != tail)
				curr = curr.getNext();

			curr.setNext(null);
			tail = curr;
		}
		size--;
		return n.getData();

	}


	// cases: empty , one data, many data
	// big-O(n)
	public E remove(int index) {
		if(index < 0 || index >= size) {
			System.out.println("out of bound!");
			return null;
		}

		Node<E> n = null;
		if(size == 1 && index == 0) {
			n = head;
			head = tail = null;
		}else {
			Node<E> curr = head;

			for(int i =0 ; i < index - 1 ; i++) 
				curr = curr.getNext();

			if(curr.getNext() == tail) {
				tail = curr;
			}

			n = curr.getNext();
			curr.setNext(curr.getNext().getNext());	
		}

		size--;

		return n.getData();

	}

	public void print() {
		if(isEmpty()) 
			System.out.println("there is not elements!!");
		else {
			Node<E> curr = head;
			while(curr != null) {
				System.out.print(curr.getData()+", ");
				curr = curr.getNext();
			}
			System.out.println();
		}

	}
	
	public static void print(SinglyLinkedList list) {
		list.moveToStart(); // list.curr = head
		for(int i = 0 ; i < list.size ; i++) {
			System.out.print(list.getValue()+", ");
			list.next();
		}
	}

	public void moveToStart() {
		curr = head;
	}

	public void moveToEnd() {
		curr = tail;
	}

	public void next() {
		if(curr != tail) {
			curr = curr.getNext();
		}
	}
	
	public E getValue() {
		return curr.getData();
	}
	
	public int size() {
		
//		without size
//		int count = 0;
//		curr = head;
//		while(curr != null) {
//			count++;
//			curr = curr.getNext();
//		}
		
		return size;
	}
	
	public E first() {
		if(head != null)
			return head.getData();
		return null;
	}
	
	// currPos, moveToPoes
	public int currPos() {
		Node<E> temp = head;
		int i =0;
		while( temp != curr) {
			temp = temp.getNext();
			i++;
		}
		
		return i;
	}
	
	public void moveToPoes(int pos) {
		if(pos < 0 || pos >= size) {
			System.out.println("Posoition out of ragne!");
		}else {
			curr = head;
			for(int i =0 ; i < pos ; i++) 
				curr = curr.getNext();
			
		}
	
	}
// O(n)
	public int search(E value) {
		curr= head;
		for(int i =0 ;i < size ; i++) {
			if(curr.getData() == value)
				return i ;
			
			curr= curr.getNext();
		}
		
		return -1;
	}
	
	public void rmoveAll() {
		head = tail = null;
		size = 0;
	}
}