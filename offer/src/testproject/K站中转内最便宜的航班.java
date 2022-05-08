package testproject;

import org.junit.Test;

import java.util.Arrays;

public class K站中转内最便宜的航班 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int t = 1; t <= k + 1; ++t) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
            }
        }
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, f[t][dst]);
        }
        return ans == INF ? -1 : ans;
    }
    //
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k){
        //表示k步之内到达i
        int[][]f=new int[k+2][n];
        final int INF = 10000 * 101 + 1;
        for(int i=0;i<k+2;i++){
            Arrays.fill(f[i],INF);
        }
        f[0][src]=0;//0步之内到达src确实等于0
        for(int t=1;t<=k+1;t++){
            for(int[]flight:flights){
                int j=flight[0],i=flight[1],cost=flight[2];
                f[t][i]=Math.min(f[t][i],f[t-1][j]+cost);
            }
        }
        int ans=INF;
        for(int t=1;t<n;t++){
            ans=Math.min(ans,f[t][dst]);
        }
        return ans==INF?-1:ans;
    }
    @Test
    public void test(){
        
    }
}
