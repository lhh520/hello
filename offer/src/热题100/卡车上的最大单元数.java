package 热题100;
import java.util.*;
public class 卡车上的最大单元数 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1]-o1[1];
                }
            });
            int sum=0;
            for(int i=0;i<boxTypes.length;i++){
                int[]cur=boxTypes[i];
                if(truckSize<cur[1]){
                    return sum+=truckSize*cur[1];
                }else {
                    sum+=cur[0]*cur[1];
                    truckSize-=cur[0];
                }
            }
            return sum;
    }
}
