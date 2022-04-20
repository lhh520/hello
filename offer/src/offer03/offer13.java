package offer03;

import org.junit.Test;

public class offer13 {

    public int movingCount(int m, int n, int k) {
        boolean[][]dp=new boolean[m][n];
        return dfs(m,n,k,0,0,dp);
    }
    public int dfs(int m,int n,int k,int i,int j,boolean[][]dp){
        if(i<0||j<0||i>=m||j>=n||!valid(i,j,k)||dp[i][j]){
            return 0;
        }
        dp[i][j]=true;
        return  1+dfs(m,n,k,i+1,j,dp)+dfs(m,n,k,i,j+1,dp);

    }
    public boolean valid(int i,int j,int k){
        int sum1=0;
        while (i!=0){
            int temp=i%10;
            sum1=sum1+temp;
            i=i/10;
        }
        int sum2=0;
        while (j!=0){
            int temp=j%10;
            sum2=sum2+temp;
            j=j/10;
        }
        return sum1+sum2<k;
    }
    @Test
    public void test(){
        int m=2;
        int n=3;
        System.out.println(movingCount(m,n,1));
    }
}
