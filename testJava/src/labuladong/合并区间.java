package labuladong;

import java.util.*;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        List<int[]>list=new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[]cur=intervals[i];
            int[]pre=list.get(list.size()-1);
            if(cur[0]>pre[1]){
                list.add(cur);
            }else if(cur[0]<=pre[1]){
                list.remove(list.size()-1);
                int[]ints=new int[]{pre[0],Math.max(pre[1],cur[1])};
                list.add(ints);
            }
        }
        int[][]ret=new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }
        return ret;
    }
}
