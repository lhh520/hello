package testproject;

import java.util.Stack;

public class 栈排序 {
    Stack<Integer>stack;
    public 栈排序() {
        stack=new Stack<>();
    }

    public void push(int val) {
        Stack<Integer>helper=new Stack<>();
        while (!stack.isEmpty()&&val>stack.peek()){
            helper.add(stack.pop());
        }
        stack.push(val);//将当前的值入栈
        while (!helper.isEmpty()){
            stack.push(helper.pop());
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
    }

    public int peek() {
        if(stack.isEmpty()){
            return 0;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
