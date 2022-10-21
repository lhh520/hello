package test2022;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures){
        Stack<Integer>stack=new Stack<>();
        stack.push(0);
        int n=temperatures.length;
        int[]ret=new int[n];
        for(int i=0;i<n;i++){
            if(stack.isEmpty()||temperatures[stack.peek()]>=temperatures[i]){
                stack.add(i);
            }else {//开始弹出栈
                while (!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                    ret[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ret;
    }
    @Test
    public void test(){
        int[]nums=new int[]{73,74,75,71,69,72,76,73};
        int[]ans=dailyTemperatures(nums);
        System.out.println(Arrays.toString(ans));
    }
}
