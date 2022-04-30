package Shopee;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers1(int[] nums){
        int n=nums.length;
        int[]count=new int[n+1];
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        for(int i=1;i<n+1;i++){
            if(count[i]==0){
                list.add(i);
            }
        }
        return list;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer>list=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i=1;i<=nums.length;i++){
            if(!map.containsKey(i)){
                list.add(i);
            }
        }
        return list;
    }
    @Test
    public void test(){
        int[]nums=new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers1(nums).toString());
    }
}
