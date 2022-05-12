package testproject;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 将数组划分成相等数对 {
    public boolean divideArray(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>entry: map.entrySet()){
            if(entry.getValue()%2!=0){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,2,3,2,2,2};
        System.out.println(divideArray(nums));
    }
}
