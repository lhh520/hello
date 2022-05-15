package 热题100;

import org.junit.Test;

import java.util.*;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//输出结果，则可以进行排序
        List<List<Integer>>ans=new ArrayList<>();
        Set<List<Integer>>set=new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int temp=nums[i];
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                if(nums[left]+nums[right]+temp==0){
                     List<Integer>list=new ArrayList<>();
                     list.add(nums[i]);
                     list.add(nums[left]);
                     list.add(nums[right]);
                     if(set.add(new ArrayList<>(list)))
                     ans.add(new ArrayList<>(list));
                }
                if(nums[left]+nums[right]+temp>0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums =new int[]{0,0,0,0};
        List<List<Integer>>ans=threeSum(nums);
        for(List<Integer>ll:ans){
            System.out.println(ll.toString());
        }

    }
}
