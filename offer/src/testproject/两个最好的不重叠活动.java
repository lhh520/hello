package testproject;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 两个最好的不重叠活动 {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->(a[0]-b[0]));
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        int max=0;
        int ans=0;
        for(int[]event:events){
            int start=event[0];
            int end=event[1];
            int val=event[2];
            //之前进入的 开始时间一定比自己小 现在需要的是结束时间比自己早
            while (pq.size()>0&&pq.peek()[1]<start){
                max=Math.max(max,pq.poll()[2]);
            }
            ans=Math.max(ans,max+val);
            pq.offer(event);
        }
        return ans;
    }
    public int maxTwoEvents1(int[][] events){
        int n=events.length;
        Arrays.sort(events,(a,b)->(a[1]-b[1]));
        int[]f=new int[n],g=new int[n];
        for(int i=0;i<n;i++){
            int low=0,high=i-1;
            while (low<high){
                int mid=(low+high)/2;
                if(events[mid][1]>=events[i][0]){
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            }
            f[i]=events[i][2];
            if(high>-1){
                g[i]=f[high]+events[i][2];
            }
            if(i>0){
                f[i]=Math.max(f[i],f[i-1]);
                g[i]=Math.max(g[i],g[i-1]);
            }
        }
        return Math.max(f[n-1],g[n-1]);
    }
}
