package hot100;

import java.util.Stack;

public class 最长有效括号 {
    public int longestValidParentheses(String s){
        Stack<Integer>stack=new Stack<>();
        int max=0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
    //
    public int longestValidParentheses1(String s){
        int maxans=0;
        int[]dp=new int[s.length()];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){//只针对右括号
                if(s.charAt(i)=='('){
                    dp[i]=(i>=2?dp[i-1]:0)+2;//当前的括号是正确的 可以继续完成
                }else if((i-dp[i-1]>0)&&s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]=dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;
                }
            }
            maxans=Math.max(maxans,dp[i]);
        }
        return maxans;
    }
}
