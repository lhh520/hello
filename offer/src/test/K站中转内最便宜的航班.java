package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K站中转内最便宜的航班 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF=10000*101+1;
        int[][]fn=new int[k+2][n];//经过i次中转到达j
        for(int i=0;i<k+2;i++){
            Arrays.fill(fn[i],INF);
        }
        fn[0][src]=0;
        for(int i=1;i<k+2;i++){
            for (int[]flight:flights){
                int ii=flight[0];
                int jj=flight[1];
                int cost=flight[2];
                //fn[i-1][ii] 第i-1次跳跃，到达了ii,然后再多一次跳跃可以到达jj，但花费需要增加
                fn[i][jj]=Math.min(fn[i][jj],fn[i-1][ii]+cost);
            }
        }
        //开始遍历第k+1次跳跃，看花费最少的航班
        int ans=INF;
        for(int i=0;i<k+2;i++){
            ans=Math.min(ans,fn[i][dst]);
        }
        return ans==INF?-1:ans;
    }
}
