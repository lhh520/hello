package 新刷题;

import org.junit.Test;

import java.util.*;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<String>set=new HashSet<>();
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i< nums.length-2;i++){
            int left=i+1,right=nums.length-1;
            while (left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    System.out.println(1111);
                    List<Integer>list=Arrays.asList(new Integer[]{nums[i],nums[left],nums[right]});
                    if(set.add(list.toString())){
                        ans.add(list);
                    }
                    left++;
                }else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[] nums=new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>>numss=threeSum(nums);
        System.out.println();
    }
}
