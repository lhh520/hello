package testproject;

import java.util.List;
import java.util.*;

public class 函数的独占时间 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[]ans=new int[n];
        Stack<Integer>stack=new Stack<>();
        int cur=-1;
        for(String log:logs){
            String[]ss=log.split(":");
            int idx=Integer.parseInt(ss[0]);
            int ts=Integer.parseInt(ss[2]);
            if(ss[1].equals("start")){
                if(!stack.isEmpty()) ans[stack.peek()]+=ts-cur;
                stack.push(idx);
                cur=ts;
            }else {
                int fun=stack.pop();
                ans[fun]+=ts-cur+1;
                cur=ts+1;
            }
        }
        return ans;
    }
}
