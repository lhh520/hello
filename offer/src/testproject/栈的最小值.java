package testproject;

import java.util.Stack;

public class 栈的最小值 {
    /** initialize your data structure here. */
    Stack<Integer>stack;
    Stack<Integer>miniStack;
    public 栈的最小值() {
        stack=new Stack<>();
        miniStack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(miniStack.isEmpty()||x<miniStack.peek()){
            miniStack.push(x);
        }

    }

    public void pop() {
        int val = stack.pop();
        if (val == miniStack.peek()){
            miniStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return miniStack.peek();
    }
}
