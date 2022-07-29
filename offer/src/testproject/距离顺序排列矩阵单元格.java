package testproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 距离顺序排列矩阵单元格 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int[]cur=new int[]{i,j};
                list.add(cur);
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int m1=Math.abs(o1[0]-rCenter)+Math.abs(o1[1]-cCenter);
                int m2=Math.abs(o2[0]-rCenter)+Math.abs(o2[1]-cCenter);
                return m1-m2;
            }
        });
        int[][]ret=new int[list.size()][2];
        for(int i=0;i<ret.length;i++){
            ret[i]=list.get(i);
        }
        return ret;
    }
}
