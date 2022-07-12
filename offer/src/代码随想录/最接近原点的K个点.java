package 代码随想录;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 最接近原点的K个点 {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]*o1[0]+o1[1]*o1[1]-o2[0]*o2[0]+o2[1]*o2[1];
            }
        });
        int[][]ret=new int[k][2];
        for(int i=0;i<k;i++){
            ret[i]=points[i];
        }
        return ret;
    }
    @Test
    public void test(){
        int[][]points =new int[][]{{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][]nn=kClosest(points,2);
        for(int i=0;i<k;i++){
            System.out.println(Arrays.toString(nn[i]));
        }
    }
}
