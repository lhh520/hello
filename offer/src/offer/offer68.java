package offer;

import org.junit.Test;

public class offer68 {
    public static int searchInsert(int[] nums, int target)
    {

        int left=0,right=nums.length-1;
        while (left<=right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
            //;
        }
        System.out.println(right);
        return left;
    }


    public static void main(String[] args) {
        int[] nums=new int[]{1,3,5,6};
        int target = 5;
        int ans=searchInsert(nums,target);
        System.out.println(ans);
    }
}
