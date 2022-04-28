package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {
    public int[][] merge(int[][] intervals){
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
        //开始排序
        List<int[]>ans=new ArrayList<>();
        int start=intervals[0][0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>intervals[i-1][1]){
                ans.add(new int[]{start,intervals[i-1][1]});
                start=intervals[i][0];
            }else {
                intervals[i][1]=Math.max(intervals[i][1],intervals[i-1][1]);
            }
        }
        ans.add(new int[]{start,intervals[intervals.length-1][1]});
        int[][]nn=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            nn[i]=ans.get(i);
        }
        return nn;
    }
    @Test
    public void test(){
        int[][]nums=new int[][]{{1,3},{1,2},{8,9}};
        merge(nums);
    }
}
