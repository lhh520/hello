package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set=new HashSet<>();
        List<Integer>list=new ArrayList<>();
        for(int i=0;i< nums.length;i++){
            if(!set.add(nums[i])){
                list.add(nums[i]);

            }
        }
        return list;
    }
    @Test
    public void test(){
        int[]nums=new int[]{4,3,2,7,8,2,3,1};
        List<Integer>list=findDuplicates(nums);
        System.out.println(list.toString());
    }
}
