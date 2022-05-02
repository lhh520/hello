package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> stack = new Stack<>();
        //直接先压入0
        stack.push(0);
        int n=temperatures.length;
        int[]res=new int[n];
        for(int i=0;i<temperatures.length;i++){
            //维持栈是单调递增的
            if(temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
            }else {//不能维持单调，则弹出栈
                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    res[stack.peek()]=i-stack.peek();//距离求解
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
    @Test
    public void test(){
        int[]temperatures =new int[] {73,74,75,71,69,72,76,73};
        int[]ans=dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ans));
    }
}
