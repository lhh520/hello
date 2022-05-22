package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        //List<int[]>list=new ArrayList<>();
        int index=0;
        int count=0;
        for(int i=0;i<intervals.length;i++){
            //System.out.println(Arrays.toString(intervals[i]));
            if(i==0){
                index=intervals[i][1];
            }
            if(i>0&&intervals[i][0]<index){
                //System.out.println(Arrays.toString(intervals[i]));
                count++;
                intervals[i][1]=Math.min(intervals[i][1],intervals[i-1][1]);
            }
        }
        return count;
    }
    @Test
    public void test(){
        int[][]intervals =new int[][]{{1,2},{2,3},{3,4},{1,3}};
        int yy=eraseOverlapIntervals(intervals);
        System.out.println(yy);
    }
}
