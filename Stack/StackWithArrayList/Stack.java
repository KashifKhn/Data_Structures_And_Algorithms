package StackWithArrayList;

import java.util.ArrayList;

public class Stack<T> {
    ArrayList<T> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(T data) {
        list.add(data);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T value = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return value;
    }

    public T peek() {
        return list.get(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

}
