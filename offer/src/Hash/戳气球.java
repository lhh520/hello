package Hash;

public class 戳气球 {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[]res=new int[n+2];
        for(int i=0;i<n+2;i++){
            if(i==0||i==n+1){
                res[i]=1;
            }else {
                res[i]=nums[i-1];
            }
        }
        int[][]dp=new int[n+2][n+2];
        for(int i=n+1;i>=0;i--){
            for(int j=i+1;j<n+2;j++){
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.max(dp[i][j],dp[i][k]+dp[k][j]+res[i]*res[k]*res[j]);
                }
            }
        }
        return dp[0][n+1];
    }
}
