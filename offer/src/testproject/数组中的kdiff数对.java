package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 数组中的kdiff数对 {
    public int findPairs(int[] nums, int k) {
        //先排序 放入哈希表中
        //Arrays.sort(nums);
        //Set<Integer>set=new HashSet<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i< nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count=0;
        for(int num: map.keySet()){
            if(map.containsKey(num+k)){
                if(k==0){
                    if(map.get(num)>1)
                    count+=1;
                }else {
                    count+=1;
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,3,1,5,4};
        System.out.println(findPairs(nums,0));
    }
}
