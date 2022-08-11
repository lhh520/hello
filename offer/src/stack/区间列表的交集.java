package stack;
import java.util.*;
public class 区间列表的交集 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]>list=new ArrayList<>();
        int lenA=firstList.length,lebB=secondList.length;
        int i=0,j=0;
        while (i<lenA&&j<lebB){
            int start=Math.max(firstList[i][0],secondList[i][0]);
            int end=Math.max(firstList[i][1],secondList[i][1]);
            if(start<end){
                list.add(new int[]{start,end});
            }
            if(firstList[i][1]<secondList[j][1]){
                i++;
            }else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
