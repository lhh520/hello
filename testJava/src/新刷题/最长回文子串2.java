package 新刷题;

import org.junit.Test;

public class 最长回文子串2 {
    //有一个需要注意的点是[0,3]取决于[1，2]，因此，需要保证[1,2]先于被判断
    //[0,1],[0,2],[0,3],即上面的遍历方法无法实现这个逻辑
    //下面的遍历顺序是[0,1],[0,2],[1,2]...可以满足这个遍历顺序，因此可以计算出正确的结果
    //以上的逻辑可以从"aaaa"这个例子中得到答案
    //启示：在做动态规划时，需要验证初始化顺序
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][]dp=new boolean[n][n];
        for (int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=2){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
            }
        }
        String str=null;
        int len=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]&&len<j-i+1){
                    len=j-i+1;
                    str=s.substring(i, j+1);
                }
            }
        }
        return str;
    }
    @Test
    public void test(){
        System.out.println(longestPalindrome("cbbd"));
    }
}
