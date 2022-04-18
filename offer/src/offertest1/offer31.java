package offertest1;

import org.junit.Test;

import java.util.Stack;

public class offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>stack=new Stack<>();
        int i=0;
        for(int num:pushed){
            stack.push(num);
            while(!stack.isEmpty()&&stack.peek()==popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
    @Test
    public void test(){
        int[]p=new int[]{1,2,3,4,5};
        int[]q=new int[]{4,5,3,2,1};
        System.out.println(validateStackSequences(p,q));
    }
}
