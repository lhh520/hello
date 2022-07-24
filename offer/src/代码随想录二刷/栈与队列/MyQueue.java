package 代码随想录二刷.栈与队列;

import java.util.Stack;

public class MyQueue {
    Stack<Integer>set1;
    Stack<Integer>set2;
    public MyQueue() {
        set1=new Stack<>();
        set2=new Stack<>();
    }

    public void push(int x) {
        set1.push(x);
    }

    public int pop() {
        if(set2.isEmpty()){
            while (!set1.isEmpty()){
                set2.add(set1.pop());
            }
        }
        return set2.pop();
    }

    public int peek() {
        if(set2.isEmpty()){
            while (!set1.isEmpty()){
                set2.add(set1.pop());
            }
        }
        return set2.peek();
    }

    public boolean empty() {
        return set1.isEmpty()&&set2.isEmpty();
    }
}
