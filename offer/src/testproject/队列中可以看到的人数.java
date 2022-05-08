package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class 队列中可以看到的人数 {
    //求下一个更大的天气
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer>stack=new Stack<>();
        stack.add(0);
        //栈里存储的是数字的索引
        int[]ans=new int[heights.length];

        for(int i=1;i<heights.length;i++){
            if(heights[i]<=stack.peek()){
                stack.add(i);
            }else {
                while (!stack.isEmpty()&&heights[i]>heights[stack.peek()]){//已经出现了大于栈顶的元素
                    ans[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.add(i);
            }


        }
        return ans;
    }
    public int[] canSeePersonsCount1(int[] heights){
        Stack<Integer>stack=new Stack<>();
        int len=heights.length;
        Stack<Integer>stack1=new Stack<>();
        int[]ans=new int[len];
        for(int i=len-1;i>=0;i--){
            while (!stack1.isEmpty()){
                ans[i]++;
                if(heights[i]<=heights[stack1.peek()]){
                    break;
                }
                stack1.pop();
            }
            stack1.add(i);
        }
        return ans;
    }
    @Test
    public void test(){
        int[]heights=new int[]{10,6,8,5,11,9};
        int[]yy=canSeePersonsCount(heights);
        System.out.println(Arrays.toString(yy));
    }
}
