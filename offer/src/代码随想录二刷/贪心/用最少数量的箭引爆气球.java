package 代码随想录二刷.贪心;

import java.util.Arrays;
import java.util.Comparator;

public class 用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else {
                    return o1[1]-o2[1];
                }
            }
        });
        int count=1;
        int last=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>last){
                count++;
                last=points[i][1];
            }else {
                last=Math.min(points[i][1],last);
            }
        }
        return count;
    }
}
