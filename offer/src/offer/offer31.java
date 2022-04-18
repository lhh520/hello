package offer;

import java.util.Stack;

public class offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>stack=new Stack<>();
        int i=0;
        for(int num:pushed)
        {
            stack.push(num);
            //当当前的值与最上面的相等时，则不断进行弹出
            while (!stack.isEmpty()&&stack.peek()==popped[i])
            {
                stack.pop();
                i++;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
