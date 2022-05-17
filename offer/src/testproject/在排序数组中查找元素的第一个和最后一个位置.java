package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length<=0){
            return new int[]{-1,-1};
        }
        if(nums.length==1){
            return new int[]{0,0};
        }
        int left=0,right=nums.length-1;
        int mid=0;
        while (left<right){
            mid=(left+right)/2;
            if(nums[mid]==target){
               break;
            }
            if(nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        //System.out.println(mid);
        //中心扩散 寻找最长的长度
        int temp = mid;
        //左移，找左边边界
        int[]res=new int[2];
        while(temp>=0&&nums[temp]==target){
            //System.out.println(temp);
            res[0] = temp;
            temp--;
        }
        //右移，找右边边界
        temp = mid;
        while(temp<nums.length&&nums[temp]==target){
            //System.out.println(temp);
            res[1]= temp;
            temp++;
        }
        return res;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,4};
        int[]dd=searchRange(nums,4);
        System.out.println(Arrays.toString(dd));
    }
}
