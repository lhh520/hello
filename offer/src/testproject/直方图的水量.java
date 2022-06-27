package testproject;

import org.junit.Test;

import java.util.Stack;

public class 直方图的水量 {
    //单调栈
    public int trap(int[] height) {
        int ans=0;
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<height.length;i++){
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int top=stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left=stack.peek();
                int curw=i-left-1;
                int curH=Math.min(height[left],height[i])-height[top];
                ans+=curw*curH;
            }
            stack.push(i);
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }
}
