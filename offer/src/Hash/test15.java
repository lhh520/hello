package Hash;

import org.junit.Test;

import java.util.*;

public class test15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>>set=new HashSet<>();
        List<List<Integer>>ans=new ArrayList<>();
        if(nums.length<3)
            return ans;
        for(int i=0;i<nums.length-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                List<Integer>list=new ArrayList<>();
                list.add(nums[i]);
                if(nums[left]+nums[right]+nums[i]==0){
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(new ArrayList<>(list));
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    left++;
                    right--;
                }else if(nums[left]+nums[right]+nums[i]<0){
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }else {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        if(nums.length<4)
            return ans;
        for(int i=0;i<nums.length;i++){

            if(i>0&&nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<nums.length;j++){

                if(j>i+1&&nums[j]==nums[j-1])
                    continue;
                int left=j+1;
                int right=nums.length-1;
                while (left<right){
                    if(nums[i]+nums[j]+nums[left]+nums[right]==target){
                         List<Integer>list=new ArrayList<>();
                         list.add(nums[i]);
                         list.add(nums[j]);
                         list.add(nums[left]);
                         list.add(nums[right]);
                         ans.add(new ArrayList<>(list));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        left++;
                         right--;
                    }else if(nums[i]+nums[j]+nums[left]+nums[right]<target){
                         left++;
                         while (left<right&&nums[left]==nums[left-1]){
                             left++;
                         }
                    } else {
                        right--;
                        while (left<right&&nums[right]==nums[right+1]){
                            right--;
                        }
                    }
                }
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{-2,-1,-1,1,1,2,2};
        List<List<Integer>>nu=fourSum(nums,0);
        for(List<Integer>list:nu){
            System.out.println(list.toString());
        }
    }

}
