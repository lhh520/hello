package 代码随想录;

import org.junit.Test;

import java.util.Arrays;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target){
        int len=nums.length;
        if(len==0){
            return new int[]{-1,-1};
        }
        int l=0,r=nums.length-1;
        int mid=0;
        while (l<=r){
            mid=(l+r)/2;
            if(nums[mid]==target){
                break;
            }
            if(nums[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        if(nums[mid]!=target){
            return new int[]{-1,-1};
        }
        int i=mid;
        while (i>=0&&nums[i]==target){
            i--;
        }
        int j=mid;
        while (j<len&&nums[j]==target){
            j++;
        }
        return new int[]{i+1,j-1};
    }
    @Test
    public void test(){
        int[]nums=new int[]{5,7,7,8,8,10};
        int[]pp=searchRange(nums,8);
        System.out.println(Arrays.toString(pp));
    }
}
