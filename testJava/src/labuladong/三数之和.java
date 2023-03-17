package labuladong;
import org.junit.Test;

import java.util.*;
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        Set<String>set=new HashSet<>();
        for(int i=0;i< nums.length-1;i++){
            int left=i+1,right=nums.length-1;
            while (left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer>list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if(set.add(list.toString()))
                    ans.add(new ArrayList<>(list));
                    left++;
                    right--;
                }else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>>lists=threeSum(nums);
        for(List<Integer>list:lists){
            System.out.println(list.toString());
        }
    }
}
