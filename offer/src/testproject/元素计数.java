package testproject;

import java.util.Arrays;

public class 元素计数 {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=nums.length-2;
        while(i<nums.length&&nums[i]==nums[0]){i++;}
        while(j>=0&&nums[j]==nums[nums.length-1]){j--;}
        return Math.max(0,j-i+1);
    }
}
