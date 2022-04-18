package stack;

import java.util.Stack;

public class test739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length;
        Stack<Integer>stack=new Stack<>();
        int[]res=new int[len];
        stack.add(0);
        for(int i=0;i<len;i++){
             if(temperatures[i]<=temperatures[stack.peek()]){
                 stack.add(i);
             }else {
                 while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                     res[stack.peek()]=i-stack.peek();
                     stack.pop();
                 }
                 stack.push(i);
             }
        }
        return res;
    }
}
