package stack;

import sun.tools.jstack.JStack;

import java.util.Arrays;
import java.util.Stack;

public class test503 {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null||nums.length<=1){
            return new int[]{-1};
        }
        int len=nums.length;
        int[]res=new int[len];
        Arrays.fill(res,-1);
        Stack<Integer>stack=new Stack<>();

        for(int i=0;i<2*len;i++){
            while (!stack.isEmpty()&&nums[i%len]>nums[stack.peek()]){
                 res[stack.peek()]=nums[i%len];
                 stack.pop();
            }
            stack.add(i%len);
        }
        return res;
    }
}
