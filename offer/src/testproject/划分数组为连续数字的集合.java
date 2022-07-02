package testproject;

import org.junit.Test;

import java.security.KeyStore;
import java.util.*;

public class 划分数组为连续数字的集合 {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();//需要一个数  每次记录着最小的数
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            set.add(nums[i]);
        }
        Arrays.sort(nums);
        for(int num:nums){
            if(!map.containsKey(num)){
                continue;
            }else {
                for(int i=0;i<k;i++){
                    if(!map.containsKey(num+i)){
                        return false;
                    }
                    map.put(num+i,map.get(num+i)-1);
                    if(map.get(num+i)<=0){
                        map.remove(num+i);
                    }
                }
            }

        }
        return true;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3,4};
        Set<Integer>set=new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        System.out.println(isPossibleDivide(nums,3));
    }
}
