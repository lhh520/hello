package 代码随想录二刷.哈希表;

import org.junit.Test;

import java.util.*;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums){
        int len=nums.length;
        Arrays.sort(nums);
        List<List<Integer>>lists=new ArrayList<>();
        Set<List<Integer>>set=new HashSet<>();
        System.out.println(1);
        for(int i=0;i<len-2;i++){
            int temp=nums[i];
            int left=i+1,right=nums.length-1;
            while (left<right){
                if(nums[left]+nums[right]+temp==0){
                    List<Integer>list=new ArrayList<>();
                    list.add(temp);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if(set.add(new ArrayList<>(list)))
                    lists.add(new ArrayList<>(list));
                }
                if(nums[left]+nums[right]+temp>0){
                    right--;
                }else {
                    left++;
                }
            }

        }
        return lists;
    }
    @Test
    public void test(){
        int[]nums=new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>>lists=threeSum(nums);
        System.out.println(lists);
    }
}
