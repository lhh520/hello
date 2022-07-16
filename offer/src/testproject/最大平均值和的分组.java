package testproject;

public class 最大平均值和的分组 {
    public double largestSumOfAverages(int[] nums, int k) {
        int N=nums.length;
        double[]p=new double[N+1];
        for(int i=0;i<N;i++){
            p[i+1]=p[i]+nums[i];
        }
        double[]dp=new double[N];
        for(int i=0;i<N;i++){
            dp[i]=(p[N]-p[i])/(N-i);
        }
        for(int m=0;m<k-1;m++){
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    dp[i]=Math.max(dp[i],(p[j]-p[i])/(j-i)+dp[j]);
                }
            }
        }
        return dp[0];
    }
}
