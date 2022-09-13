package plan92.yyyy;

public class test989 {
    public int maxScore (int energy, int[][] actions) {
         int[]dp=new int[energy+1];
         int w=actions.length;
         for(int i=0;i<w;i++){
              for(int j=energy;j>=actions[i][0];j--){
                  dp[j]=Math.max(dp[j],dp[j-actions[i][0]]+actions[i][1]);
              }
         }
         return dp[energy];
    }
}
