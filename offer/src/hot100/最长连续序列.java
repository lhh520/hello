package hot100;

import org.junit.Test;

import java.util.*;

public class 最长连续序列 {
    public int longestConsecutive(int[] nums){
        Arrays.sort(nums);
        int len=nums.length;
        int[]dp=new int[len];
        Arrays.fill(dp,1);
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[j]==nums[i]-1){
                    dp[i]=Math.max(dp[j],dp[i])+1;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        int max=0;
        for(int i=0;i<len;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    //
    public int longestConsecutive1(int[] nums){
        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int max=0;
        for(int num:set){

            if(!set.contains(num-1)){
                int cur=num;
                int curlong=1;
                while (set.contains(cur+1)){
                    cur++;
                    curlong+=1;
                }
                max=Math.max(max,curlong);
            }

        }
        return max;
    }
    @Test
    public void test(){
        int[]nums=new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive1(nums));
    }
}
