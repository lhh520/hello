package testproject;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 最低加油次数 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int ans=0,prev=0,fuel=startFuel;
        int n=stations.length;
        for(int i=0;i<=n;i++){
            int curr=i<n?stations[i][0]:target;
            fuel-=curr-prev;
            while (fuel<0&&!pq.isEmpty()){
                fuel+=pq.poll();
                ans++;
            }
            if(fuel<0){
                return -1;
            }
            if(i<n){
                pq.offer(stations[i][1]);
                    prev=curr;

            }
        }
        return ans;
    }
}
