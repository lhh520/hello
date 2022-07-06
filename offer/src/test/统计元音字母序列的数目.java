package test;

import org.junit.Test;

import java.util.Arrays;

public class 统计元音字母序列的数目 {
    public int countVowelPermutation(int n) {
        int MOd= (int) (1e9 + 7);
        int[][]dp=new int[n][5];
        Arrays.fill(dp[0],1);
        if(n==1){
            return 5;
        }
        for(int i=1;i<n;i++){
            dp[i][0]+=dp[i-1][1]%MOd;
            dp[i][1]+=(dp[i-1][0]%MOd+dp[i-1][2]%MOd)%MOd;
            dp[i][2]+=(dp[i-1][0]%MOd+dp[i-1][1]%MOd+dp[i-1][3]%MOd+dp[i-1][4]%MOd)%MOd;
            dp[i][3]+=(dp[i-1][2]%MOd+dp[i-1][4]%MOd)%MOd;
            dp[i][4]+=dp[i-1][0]%MOd;
        }
        int sum=0;
        for(int i=0;i<5;i++){
            sum+=(dp[n-1][i]%MOd);
        }
        return sum%MOd;
    }
    @Test
    public void test(){
        System.out.println(countVowelPermutation(2));
    }
}
