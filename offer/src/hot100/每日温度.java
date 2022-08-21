package hot100;

import org.junit.Test;

import java.util.Stack;

public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>stack=new Stack<>();
        stack.push(0);
        int n=temperatures.length;
        int[]res=new int[n];
        for(int i=0;i<temperatures.length;i++){
            if(temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
            }else {//开始弹出栈
                while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    res[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }

        }
        return res;
    }
    @Test
    public void test(){
        int[]temperatures =new int[]{73,74,75,71,69,72,76,73};

    }
}
