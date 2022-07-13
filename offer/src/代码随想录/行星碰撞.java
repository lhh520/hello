package 代码随想录;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class 行星碰撞 {
    public int[] asteroidCollision(int[] asteroids){
        Stack<Integer>stack=new Stack<>();
        for(int num:asteroids){
            if(num<0){
            //如果向左的一直很大，则栈需要一直进行弹出
            while (!stack.isEmpty()&&stack.peek()>0&&stack.peek()<-num){
                stack.pop();
            }
            //表示如果栈为空，或者栈顶为负数，则可以一直进展
            if(stack.isEmpty()||stack.peek()<0){
                stack.push(num);
            }else if(!stack.isEmpty()&&stack.peek()==-num) {
                stack.pop();
            }}
            else {
                stack.push(num);
            }
        }
        int[]ret=new int[stack.size()];
        for(int ii=ret.length-1;ii>=0;ii--){
            ret[ii]=stack.pop();
        }
        return ret;
    }
    @Test
    public void test(){
        int[]asteroids =new int[]{5,10,-5};
        int[]ret=asteroidCollision(asteroids);
        System.out.println(Arrays.toString(ret));
    }
}
