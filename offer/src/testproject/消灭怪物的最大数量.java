package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 消灭怪物的最大数量 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int len=dist.length;
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<len;i++){
            list.add((dist[i]-1)/speed[i]);//最晚时间
        }
        Collections.sort(list);
        for(int i=0;i<len;i++){//先消灭要来的怪物
            if(list.get(i)<i){
                return i;
            }
        }
        return len;
    }
    @Test
    public void test(){
        int[]dist =new int[]{1,3,4};
        int[]speed =new int[]{1,1,1};
        System.out.println(eliminateMaximum(dist,speed));
    }
}
