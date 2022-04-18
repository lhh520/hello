package test;

import java.util.ArrayList;
import java.util.List;
//todo
public class test57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left=newInterval[0];
        int right=newInterval[1];
        List<int[]>list=new ArrayList<>();
        boolean isplaced=false;
        for (int i = 0; i <intervals.length; i++) {
            //没有重叠，并且在左边，如果没有放入，才可以放入，不然可以一直向右进行
            if(intervals[i][0]>right)
            {   if(!isplaced)
            {list.add(new int[]{left,right});
                isplaced=true;}
                list.add(intervals[i]);
            }
            //没有重叠，在右边,可以继续进行遍历，因此只需要插入当前即可。
            else if(intervals[i][1]<left)
            {
                list.add(intervals[i]);
                //list.add(new int[]{left,right});
            }
            //有重叠，更新下left和right，进行对比，进入下一轮
            else
            {
                left=Math.min(left,intervals[i][0]);
                right=Math.max(right,intervals[i][1]);
            }
        }
        //如果遍历完成，还没有被放入，则需要直接填入最后
        if(!isplaced)
        {
            list.add(new int[]{left,right});
        }
        int[][] nums=new int[list.size()][2];
        for (int i = 0; i <list.size(); i++) {
            nums[i]=list.get(i);
        }
        return nums;
    }
}
