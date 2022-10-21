package hot100;
import java.util.*;
public class CQueue {
    Stack<Integer>stack1;
    Stack<Integer>stack2;
    public CQueue() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
        return;
    }

    public int deleteHead() {
        if (stack2.isEmpty()&&stack1.isEmpty()){
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
