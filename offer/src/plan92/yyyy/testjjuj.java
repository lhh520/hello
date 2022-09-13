package plan92.yyyy;

public class testjjuj {
    public int minVehiclePaintingCost (int[][] costs) {
        // write code here
        int len=costs.length;
        int m=costs[0].length;
        int[][]dp=new int[len+1][m];
//        if(len<2){
//            return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
//        }
        for(int i=1;i<=len;i++){
            for(int j=0;j<m;j++){
                int xx=Integer.MAX_VALUE;
                for(int k=0;k<m;k++){
                    if(k!=j){
                        xx=Math.min(xx,dp[i-1][k]);
                    }
                }
                dp[i][j]=xx+costs[i-1][j];
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            ans=Math.min(ans,dp[len][i]);
        }
        return ans;
    }
}
