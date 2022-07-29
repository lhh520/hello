package testproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 用栈操作构建数组 {
    private final static String PUSH="Push";
    private final static String POP="Pop";
    public List<String> buildArray(int[] target, int n) {
        List<String>ans=new ArrayList<>();
        Stack<Integer>stack=new Stack<>();
        for(int num=1,index=0;num<=n&&index<target.length;num++){
            stack.add(num);//先放入数据
            ans.add(PUSH);
            if(target[index]!=stack.peek()){
                stack.pop();
                ans.add(POP);
            }else {//如果等于 就不需要pop
                index++;
            }
        }
        return ans;
    }
}
