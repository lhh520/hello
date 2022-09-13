package plan92.test;

import org.junit.Test;
import sun.tools.jstack.JStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class 不同的二叉搜索树 {
    public int numTrees(int n){
        if(n<=2){
            return n;
        }
        int[]dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[i-j]*dp[j-1];
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println(numTrees(3));
    }
}
