package hot100;

import java.util.*;

public class MyStack {
    Queue<Integer>queue1;
    Queue<Integer>queue2;
    public MyStack() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        Queue<Integer>temp=queue1;
        queue1=queue2;
        queue2=temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
