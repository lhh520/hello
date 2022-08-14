package 代码随想录二刷.贪心;

import org.junit.Test;

import java.util.*;

public class 合并区间 {
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else {
                    return o1[1]-o2[1];
                }
            }
        });
        System.out.println(1);
        List<int[]>list=new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[]cur=intervals[i];
            if(cur[1]<list.get(list.size()-1)[1]){
                continue;
            }else if(cur[0]>list.get(list.size()-1)[1]){
                list.add(cur);
            }else if(cur[0]<=list.get(list.size()-1)[1]){//表示处于两者之间
                int[]temp=list.get(list.size()-1);
                int[]now=new int[]{temp[0],Math.max(temp[1],cur[1])};
                list.remove(list.size()-1);
                list.add(now);
                }
        }
        int[][]ret=new int[list.size()][];
        for(int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }
        return ret;
    }
    @Test
    public void test(){
        //intervals = [[1,4],[0,4]]
        int[][]intr=new int[][]{{1,4},{0,4}};
        int[][]rew=merge(intr);
        for(int[]ans:rew){
            System.out.println(Arrays.toString(ans));
        }
    }
}
