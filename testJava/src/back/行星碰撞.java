package back;
import java.util.*;
public class 行星碰撞 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack=new Stack<>();
        for(int num:asteroids){
            if(num<0){
                //抵消向左运动的
                while (!stack.isEmpty()&&stack.peek()>0&&stack.peek()<-num){
                    stack.pop();
                }
                if(stack.isEmpty()||stack.peek()<0){
                    stack.push(num);
                }else if(!stack.isEmpty()||stack.peek()==-num){
                    stack.pop();
                }
            }else {
                stack.push(num);
            }
        }
        int[]ret=new int[stack.size()];
        for(int ii=ret.length-1;ii>0;ii--){
            ret[ii]=stack.pop();
        }
        return ret;
    }
}
