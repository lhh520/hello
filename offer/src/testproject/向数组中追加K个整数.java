package testproject;

import org.junit.Test;

import java.util.*;

public class 向数组中追加K个整数 {
    public long minimalKSum(int[] nums, int k) {
        Set<Long>set=new HashSet<>();
        long sum=0;
        long cur=0,index=1;
        for(int i=0;i<nums.length;i++){
            set.add((long) nums[i]);
        }
        while (cur<k){
            while (set.contains(index)){
                index++;
            }
            set.add(index);
            sum+=index;
            cur++;
        }
        return sum;
    }
    //
    public long minimalKSum1(int[] nums, int k){
        Arrays.sort(nums);
        long sum=(1L+k)*k/2;
        long curSum=k;//当前追加的初始值大小
        if(nums[0]>k) return sum;
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i-1]==nums[i]) continue;
            if(nums[i]<=curSum){
                curSum++;
                sum=sum-nums[i]+curSum;
            }
        }
        return sum;
    }
    public long minimalKSum2(int[] nums, int k){
        Arrays.sort(nums);
        Set<Integer>set=new HashSet<>();
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(set.add(nums[i])){
                list.add(nums[i]);
            }
        }
        list.add((int) (1e9+1e5+1));
        long sum=0;
        for(int i=0;i<list.size();i++){
            if(nums[i]-i-1>=k){//表示前面已经有了足够多的空位,有了足够多的空位以后
                return (k+i)*(1+k+i)/2-sum;
            }
            sum+=nums[i];
        }
        return -1;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,4,25,10,25};
        System.out.println(minimalKSum(nums,2));
    }
}
