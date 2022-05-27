package 代码随想录;

import org.junit.Test;

public class 一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        //双重背包问题
        int[][]dp=new int[m+1][n+1];
        for(String str:strs){
            int zeroNum=0;
            int oneNum=0;
            //计算当前的数字的价值
            for(int ii=0;ii<str.length();ii++){
                if(str.charAt(ii)=='0'){
                    zeroNum++;
                }else if(str.charAt(ii)=='1'){
                    oneNum++;
                }
            }
            //背包从大到小遍历
            for(int i=m;i>=zeroNum;i--){
                for(int j=n;j>=oneNum;j--){
                    //计算数量 计算成为当前值的数量
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeroNum][j-oneNum]+1);
                }
            }
        }
        return dp[m][n];
    }
    @Test
    public void test(){
        String[] strs=new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs,5,3));
    }
}
