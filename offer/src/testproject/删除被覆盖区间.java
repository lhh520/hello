package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 删除被覆盖区间 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });
        List<int[]>list=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            while(!list.isEmpty()&&i<intervals.length&&list.get(list.size()-1)[0]<=intervals[i][0]&&list.get(list.size()-1)[1]>=intervals[i][1]){
                i++;
            }
            if(i<intervals.length)
            list.add(intervals[i]);
        }
        return list.size();
    }
    @Test
    public void test(){
        int[][]intervals =new int[][]{{1,4},{3,6},{2,8}};
        System.out.println(removeCoveredIntervals(intervals));
    }
}
