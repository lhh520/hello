package dp;

import org.junit.Test;

public class test474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][]dp=new int[m+1][n+1];
        for(String str:strs){
           int zeronum=0,onenum=0;
           for(int i=0;i<str.length();i++){
               if(str.charAt(i)=='0')
                   zeronum++;
               if(str.charAt(i)=='1')
                   onenum++;
           }
           for(int i=m;i>=zeronum;i--){
               for(int j=n;j>=onenum;j--){
                  dp[i][j]=Math.max(dp[i][j],dp[i-zeronum][j-onenum]+1);
               }
           }
        }
        return dp[m][n];
    }
    @Test
    public void test(){
        String[]strs=new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs,5,3));
    }
}
