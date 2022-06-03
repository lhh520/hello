package test;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Stack;

public class 最小栈 {
    Stack<Integer>stack;
    PriorityQueue<Integer>pq;
    public 最小栈() {
        stack=new Stack<>();
        pq=new PriorityQueue<>();
    }

    public void push(int val) {
        stack.push(val);
        pq.add(val);
    }

    public void pop() {
        int uu=stack.pop();
        pq.remove(uu);
    }

    public int top() {
        return (!stack.isEmpty())?stack.peek():-1;
    }

    public int getMin() {
        return (!pq.isEmpty())?pq.peek():-1;
    }

}
