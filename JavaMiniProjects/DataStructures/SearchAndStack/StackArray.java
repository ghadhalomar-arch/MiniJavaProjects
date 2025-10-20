public class StackArray {
    private int[] stack;
    private int top;
    private int capacity;

    public StackArray(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    // push element
    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
    }

    // pop element
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    // peek top element
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

}

