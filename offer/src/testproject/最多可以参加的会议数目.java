package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最多可以参加的会议数目 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int res=0;
        int currDay=1;
        int i=0;
        int n=events.length;
        while (i<n||!pq.isEmpty()){
            //等于当前的值，全都放入进去
            while (i<n&&currDay==events[i][0]){
                pq.add(events[i][1]);
                i++;
            }
            //已经结束的会议弹出堆，表示不能再参加了
            while(!pq.isEmpty()&&pq.peek()<currDay){
                pq.remove();
            }
            //选择结束时间最小的来参加
            if(!pq.isEmpty()){
                pq.remove();
                res++;
            }
            currDay++;
        }
        return res;
    }
    @Test
    public void test(){
        int[][]events=new int[][]{{1,2},{2,3},{3,4},{1,2}};
        System.out.println(maxEvents(events));
    }
}
