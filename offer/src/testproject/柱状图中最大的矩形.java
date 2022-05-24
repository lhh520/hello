package testproject;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class 柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res=0;
        Deque<Integer>stack=new ArrayDeque<>(len);
        for(int i=0;i<len;i++){
            while (!stack.isEmpty()&&heights[i]<heights[stack.peekLast()]){
                int curHeight=heights[stack.pollLast()];
                while (!stack.isEmpty()&&heights[stack.peekLast()]==curHeight){
                    stack.peekLast();
                }
                int curWidth;
                if(stack.isEmpty()){
                    curWidth=i;
                }else {
                    curWidth=i-stack.peekLast()-1;
                }
                res=Math.max(res,curHeight*curWidth);
            }
            stack.addLast(i);
        }
        //此时栈里面只剩下递增的
        while (!stack.isEmpty()){
            int curHeight=heights[stack.pollLast()];
            while (!stack.isEmpty()&&heights[stack.peekLast()]==curHeight){
                stack.pollLast();
            }
            int curWidth;
            if(stack.isEmpty()){
                curWidth=len;
            }else {
                curWidth=len-stack.peekLast()-1;
            }
            res=Math.max(res,curHeight*curWidth);
        }
        return res;
    }
    @Test
    public void test(){
        int[]heights =new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
