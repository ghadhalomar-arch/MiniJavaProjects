package data_structures;

public class Queue<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;
        
        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }
    
    private Node<E> front;
    private Node<E> rear;
    private int size;
    
    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E element = front.element;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return element;
    }
    
    public E first() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.element;
    }
    
    public E peek() {
        return first();
    }
    
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public boolean contains(E element) {
        Node<E> current = front;
        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public void printQueue() {
        Node<E> current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }
}
