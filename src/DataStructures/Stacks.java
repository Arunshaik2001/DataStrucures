package DataStructures;

import java.util.LinkedList;

public class Stacks<T> {
    private int top=-1;
    private int size=10;
    private LinkedList<T> stack;
    Stacks(int size){
        this.size=size;
        this.stack = new LinkedList<>();
    }

    public void push(T value){
        if (top==size-1)return;
        stack.add(value);
        top++;
    }

    public T pop(){
        if (top==-1)return null;
        return stack.remove(top--);
    }

    public T top(){
        if (top==-1)return null;
        T value = stack.removeLast();
        top--;
        return value;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==size-1;
    }
}
