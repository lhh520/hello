package 代码随想录二刷;

import org.junit.Test;

import java.util.*;

public class 贪心算法 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        List<Integer>list=new ArrayList<>();
        int ans=0;
        list.add(0);
        for(int i=0;i<flowerbed.length;i++){
            list.add(flowerbed[i]);
        }
        for(int i=0;i<list.size()-2;i++){
            if(list.get(i)==0&&list.get(i+1)==0&&list.get(i+2)==0){
                list.set(i+1,1);
                ans++;
            }
        }
        if(ans>=n){
            return true;
        }else {
            return false;
        }
    }
    @Test
    public void test(){
        String s="27";
        int number=-1&8;
        System.out.println(Integer.toBinaryString(number));
    }
}
