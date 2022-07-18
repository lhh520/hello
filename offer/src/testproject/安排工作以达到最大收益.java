package testproject;

import java.util.Arrays;

public class 安排工作以达到最大收益 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int len=difficulty.length;
        int[][]dist=new int[len][2];
        for(int i=0;i<difficulty.length;i++){
            dist[i][0]=difficulty[i];
            dist[i][1]=profit[i];
        }
        int low=0;
        int max=0;
        int res=0;
        Arrays.sort(dist,(a,b)->(a[0]-b[0]));
        for(int i=0;i<worker.length;i++){
            int a=worker[i];
            while (low<len&&dist[low][0]<=worker[i]){//表示为可以满足的条件
                if(dist[low][1]>max) max=dist[low][1];
                low++;
            }
            res+=max;
        }
        return res;
    }
}
