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
        List<int[]>list=new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[]cur=intervals[i];
            if(cur[1]<list.get(list.size()-1)[1]){//最大值小于当前的值 直接跳过
                continue;
            }else if(cur[0]>list.get(list.size()-1)[1]){
                list.add(cur);
            }else {
                int[]pre=list.get(list.size()-1);
                list.remove(list.size()-1);
                int[]now=new int[]{pre[0],cur[1]};
                list.add(now);
            }
        }
        int[][]ret=new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }
        return ret;
    }
}
