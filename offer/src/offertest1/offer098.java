package offertest1;

import org.junit.Test;

public class offer098 {
    int ans=0;
    public int uniquePaths(int m, int n) {
        //boolean[][]dp=new boolean[m][n];
        int[][]dp=new int[m][n];
        //dfs(dp,0,0);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j]=1;
                }
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public void dfs(boolean[][]dp,int i,int j){
        if(i<0||i>=dp.length||j<0||j>=dp[0].length){
            return;
        }
        if(dp[i][j]==true)
            return;
        if(i==dp.length-1&&j==dp[0].length-1){
            ans++;
        }
        dp[i][j]=true;
        dfs(dp,i+1,j);
        dfs(dp,i,j+1);
        dp[i][j]=false;
    }
    @Test
    public void test(){
        int u=uniquePaths(3,7);
        System.out.println(u);
    }
}
