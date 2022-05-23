package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 不含特殊楼层的最大连续楼层数 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        List<Integer>list=new ArrayList<>();
        list.add(bottom-1);
        list.add(top+1);
        for(int i=0;i<special.length;i++){
            list.add(special[i]);
        }
        Collections.sort(list);
        int ans=0;

        for(int i=0;i<list.size()-1;i++){
            ans=Math.max(ans,list.get(i+1)-list.get(i)-1);
        }
        return ans;
    }
    @Test
    public void test(){
        int bottom = 2, top = 9;
        int[]special =new int[]{4,6};
        System.out.println(maxConsecutive(bottom,top,special));
    }
}
