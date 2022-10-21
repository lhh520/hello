import java.util.*;
public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>stack=new Stack<>();
        stack.push(0);
        int n=temperatures.length;
        int[]res=new int[n];
        for(int i=0;i<temperatures.length;i++){
            if(temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
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
