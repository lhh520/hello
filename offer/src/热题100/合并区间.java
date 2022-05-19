package 热题100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
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
            int[]cur=intervals[i];
            if(list.size()>=1&&cur[0]<=list.get(list.size()-1)[1]){
                int[] temp=list.get(list.size()-1);
                list.remove(list.size()-1);
                temp[1]=Math.max(cur[1],temp[1]);
                list.add(temp);
            }else {
                list.add(cur);
            }
        }
        int[][]ans=new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    @Test
    public void test(){
        int[][]inve=new int[][]{{1,3},{1,2},{8,10},{15,18}};
        int[][]mm=merge(inve);
        for (int i=0;i<mm.length;i++)
            System.out.println(Arrays.toString(mm[i]));
    }
}
