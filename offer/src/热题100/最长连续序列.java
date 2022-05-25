package 热题100;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        Arrays.sort(nums);
        //int i=1;
        int count=1;
        int ans=1;
        //System.out.println(Arrays.toString(nums));
        for(int i=1;i<nums.length;i++){
            //相等则继续向右
            if(nums[i]==nums[i-1]){
                continue;
            }
            //满足条件
            if(nums[i]==nums[i-1]+1){
                count++;
            }else {//出现不相等的情况，则直接进行归零，并且比较
                ans=Math.max(count,ans);
                count=1;
            }

        }
        return Math.max(count,ans);
    }

    public int longestConsecutive1(int[] nums){
        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longest=0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int curNum=num;
                int currentlong=1;
                while (set.contains(curNum+1)){
                    curNum++;
                    currentlong++;
                }
                longest=Math.max(longest,currentlong);
            }
        }
        return longest;
    }

    @Test
    public void test(){
        int[]nums=new int[]{1,2,0,1};
        System.out.println(longestConsecutive(nums));
    }
}
