package face;
import org.junit.Test;

import java.util.*;
public class 打折购买糖果的最小开销 {
    public int minimumCost(int[] cost) {
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<cost.length;i++){
            list.add(cost[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(list);
        int ret=0;
        for(int i=0;i<cost.length;i++){
            if(i%3!=2){
                ret+=list.get(i);
            }
        }
        return ret;
    }
    @Test
    public void test(){
        int[]cost =new int[]{10,5,9,4,1,9,10,2,10,8};
        System.out.println(minimumCost(cost));
    }
}
