package StackWithArray;

public class Stack<T> {
    private T[] list;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.list = (T[]) new Object[size];
        this.top = -1;
    }

    private boolean isFull() {
        return this.top + 1 == list.length;
    }

    private boolean isEmpty() {
        return this.top == -1;
    }

    public void push(T data) {
        if (isFull()) {
            System.out.println("Stack is Full");
            return;
        }
        this.list[++top] = data;
    }

    public T pop() {
        return isEmpty() ? null : this.list[top--];
    }

    public T peek() {
        return this.list[top];
    }

    public int size() {
        return top + 1;
    }
}
