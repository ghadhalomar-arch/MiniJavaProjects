package data_structures;

public class ArrayQueue<E> {
    private E[] data;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void enqueue(E element) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        rear = (rear + 1) % data.length;
        data[rear] = element;
        size++;
    }
    
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E element = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
        return element;
    }
    
    public E first() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }
    
    public E peek() {
        return first();
    }
    
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        rear = size - 1;
    }
    
    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % data.length;
            if (data[index].equals(element)) {
                return true;
            }
        }
        return false;
    }
    
    public void printQueue() {
        System.out.print("ArrayQueue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % data.length;
            System.out.print(data[index] + " ");
        }
        System.out.println();
    }
}
