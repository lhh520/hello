package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class 行星碰撞 {
    public int[] asteroidCollision(int[] asteroids) {
        //单调栈
        Stack<Integer>stack=new Stack<>();
        for(int num:asteroids){
            if(num<0){
                while (!stack.isEmpty()&&stack.peek()>0&&stack.peek()<-num){
                    stack.pop();
                }
                if(stack.isEmpty()||stack.peek()<0){
                    stack.push(num);
                }else if(!stack.isEmpty()&&stack.peek()==-num){
                    stack.pop();
                }
            }else {
                stack.push(num);
            }
        }

        int[] ret = new int[stack.size()];
        for (int ii = ret.length - 1; ii >= 0; ii--) {
            ret[ii] = stack.pop();
        }
        return ret;
    }
    @Test
    public void test(){
        int[]nums=new int[]{-2,-1,1,2};
        int[]ans=asteroidCollision(nums);
        System.out.println(Arrays.toString(ans));
    }
}
