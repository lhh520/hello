package testproject;

public class 最大平均数的分组 {
    public double largestSumOfAverages(int[] nums, int k) {
        int N=nums.length;
        double[]P=new double[N+1];
        for(int i=0;i<N;i++){
            P[i+1]=P[i]+nums[i];//求前缀和
        }
        double[]dp=new double[N];
        for(int i=0;i<N;i++){
            dp[i]=(P[N]-P[i])/(N-i);
        }
        for(int m=0;m<k-1;m++){
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    dp[i]=Math.max(dp[i],(P[j]-P[i])/(j-i)+dp[j]);
                }
            }
        }
        return dp[0];
    }
    public double largestSumOfAverages1(int[] nums, int k){
        int N=nums.length;
        double[]P=new double[N+1];
        double[][]dp=new double[N+1][k+1];
        for(int i=1;i<=N;i++){
            P[i]=P[i-1]+nums[i];
        }
        for(int i=1;i<=N;i++){
            dp[i][1]=P[i]/i;
            for(int m=2;m<=k&&k<=i;m++){
                for(int j=1;j<i;j++){
                    dp[i][k]=Math.max(dp[i][k],dp[j][k-1]+(P[i]-P[j])/(i-j));
                }
            }
        }
        return dp[N][k];
    }
}
