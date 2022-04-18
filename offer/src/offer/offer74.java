package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class offer74 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<2)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> list=new ArrayList<>();
        list.add(intervals[0]);
        System.out.println(Arrays.toString(list.get(0)));
        int len=intervals.length;
        for(int i=1;i<len;i++)
        {
            System.out.println(i);//i=2
            int a=intervals[i][0];
            int b=list.get(list.size()-1)[1];
            System.out.println(a);
            if(a>b)
            {
                list.add(intervals[i]);
            }
            if(a<=b)
            {
                list.get(list.size()-1)[1]=Math.max(intervals[i][1],list.get(list.size()-1)[1]);
            }

        }
        System.out.println(list.toString());
        int[][]ans=new int[list.size()][2];
        for(int i=0;i<list.size();i++)
        {
            ans[i]=list.get(i);
        }
        return ans;
    }
    @Test
    public void test()
    {
       int[][]nums=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int [][]ans=merge(nums);
        //System.out.println(Arrays.toString(ans));
    }
}
