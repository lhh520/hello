package hot100;
import java.util.*;
public class 柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights){
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
            while (!stack.isEmpty()&&heights[i]<stack.peek()){
                int curHeight=heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }
                int curWidth;
                if(stack.isEmpty()){
                    curWidth=i;
                }else {
                    curWidth=i-stack.pollLast()-1;
                }
                res=Math.max(res,curHeight*curWidth);
            }
            stack.addLast(i);
        }
        //
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;

    }
}
