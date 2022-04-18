package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class test435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i <intervals.length; i++) {
            System.out.println(Arrays.toString(intervals[i]));
        }

        //
        int count=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<intervals[i-1][1]){
                count++;
                intervals[i][1]=Math.min(intervals[i][1],intervals[i-1][1]);
            }
        }
        return count;
    }
    @Test
    public void test(){
        int[][]nums=new int[][]{{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(nums));
    }
}
