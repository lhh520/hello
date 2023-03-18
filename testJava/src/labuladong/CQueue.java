package labuladong;

import java.util.Stack;

public class CQueue {
    Stack<Integer>stack1=new Stack<>();
    Stack<Integer>stack2=new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty()&&stack2.isEmpty()){
            return -1;
        }
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
