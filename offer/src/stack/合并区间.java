package stack;
import org.junit.Test;

import java.util.*;
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[]o1,int[]o2){
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        List<int[]>list=new ArrayList<>();
        int i=1;
        list.add(intervals[0]);
        while (i<intervals.length){
            int[]cur=intervals[i];
            if(cur[1]<=list.get(list.size()-1)[1]){
                i++;
                continue;
            }else if(cur[0]>list.get(list.size()-1)[1]){
                list.add(cur);
                i++;
            }else if(cur[1]>list.get(list.size()-1)[1]) {
                int[] temp = new int[]{list.get(list.size() - 1)[0], cur[1]};
                list.set(list.size() - 1, temp);
                i++;
            }
        }
        int[][]res=new int[list.size()][2];
        for(int ii=0;ii<res.length;ii++){
            res[ii]=list.get(ii);
        }
        return res;
    }
    @Test
    public void test(){
        //intervals = [[1,3],[2,6],[8,10],[15,18]]
        int[][]intervals =new int[][]{{1,4},{1,5}};
        int[][]interv=merge(intervals);
        for(int[]ii:interv){
            System.out.println(Arrays.toString(ii));
        }
    }
}
