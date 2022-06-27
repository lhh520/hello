package testproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 对角线遍历II {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> lists=new ArrayList<>();
        int rows=nums.size();
        for(int i=0;i<rows;i++){
            List<Integer>cur=nums.get(i);
            int len=cur.size();
            for(int j=0;j<len;j++){
                int num=cur.get(j);
                lists.add(new int[]{i+j,j,num});
            }
        }
        Collections.sort(lists, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else {
                    return o1[1]-o2[1];
                }
            }
        });
        int[]ret=new int[lists.size()];
        for(int i=0;i<lists.size();i++){
            ret[i]=lists.get(i)[2];
        }
        return ret;
    }
}
