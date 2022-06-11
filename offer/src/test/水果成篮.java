package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 水果成篮 {
    public int totalFruit(int[] fruits) {
        //窗口中只有两个数字 且长度最长
        Map<Integer,Integer>map=new HashMap<>();//用于存储数字 合法长度为2
        int left=0,right=0;
        int len=fruits.length;
        int max=0;
        while (right<len){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            //窗口缩小
            while (map.size()>2){
                if(map.containsKey(fruits[left])){
                    map.put(fruits[left],map.get(fruits[left])-1);
                    if(map.get(fruits[left])==0){
                        map.remove(fruits[left]);
                    }
                }
                left++;
            }
            max=Math.max(max,right-left+1);
            right++;

        }
        return max;
    }
    @Test
    public void test(){
        int[]fruits=new int[]{1,2,3,2,2};

        System.out.println(totalFruit(fruits));
    }
}
