import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class test56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)
            return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]>merged=new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            int L=intervals[i][0],R=intervals[i][1];
            //如果合并数组为空，或者当前的的最大的数小于新的数组的左边，则直接加入即可
            if(merged.size()==0||merged.get(merged.size()-1)[1]<L)
                merged.add((new int[]{L,R}));
            //需要合并的数组
            else
                //右边的
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],intervals[i][1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }
    @Test
    public void test()
    {
        int[][]nums=new int[][]{{1,2},{3,4}};
        int[][]ans=merge(nums);
        System.out.println(Arrays.toString(ans[0]));

    }

}
