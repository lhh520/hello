package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test011 {
    public int findMaxLength(int[] nums) {
        int maxLen=0;
        Map<Integer,Integer>map=new HashMap<>();
        int counter=0;//counter为前缀和
        map.put(counter,-1);//map中存储的是（前缀和，索引）
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(num==1){
                counter++;
            }
            else{
                counter--;
            }
            if(map.containsKey(counter)){//如果前缀和出现过，则可以进行计数
                int prevIndex=map.get(counter);//用来得到索引
                maxLen=Math.max(maxLen,i-prevIndex);
            }else{
                map.put(counter,i);
            }
        }
        return maxLen;
    }
    @Test
    public void tesr(){
        int[]nums=new int[]{0,1,0};
        System.out.println(findMaxLength(nums));
    }
}
