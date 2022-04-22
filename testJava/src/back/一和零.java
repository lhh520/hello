package back;

import org.junit.Test;

public class 一和零 {
    public int findMaxForm(String[] strs, int m, int n){
        int[][]dp=new int[m+1][n+1];
        for(String str:strs){//物品的遍历
            int zeronum=0,onenum=0;

            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='1')
                    onenum++;
                if(str.charAt(i)=='0')
                    zeronum++;
            }
            //
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
        String[]ans=new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(ans,5,3));
    }
}
