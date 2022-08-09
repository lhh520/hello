package testproject;
import org.junit.Test;

import java.util.*;
public class 算术三元组的数目 {
    public int arithmeticTriplets(int[] nums, int diff) {
       Map<Integer,Integer>map=new HashMap<>();
       for(int i=0;i< nums.length;i++){
           map.put(nums[i],i);
       }
       int ret=0;
       for(int i=0;i<nums.length;i++){
           if(map.containsKey(diff+nums[i])&&map.containsKey(diff+diff+nums[i])){
               ret++;
           }
       }
       return ret;
    }
    @Test
    public void test(){
        int[]nums=new int[]{0,1,4,6,7,10};
        System.out.println(arithmeticTriplets(nums,3));
    }
}
