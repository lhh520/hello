package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 寻找两个正序数组的中位数 {
    //输入：nums1 = [1,2], nums2 = [3,4]
    //输出：2.50000
    //解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        int[]nums=new int[n1+n2];
        int i=0,j=0,k=0;
        while (i<n1||j<n2){
            int t1=i>=nums1.length?Integer.MAX_VALUE:nums1[i];
            int t2=j>=nums2.length?Integer.MAX_VALUE:nums2[j];
            if(t1<=t2){
                i++;
                nums[k++]=t1;
            }else {
                j++;
                nums[k++]=t2;
            }
        }
        System.out.println(Arrays.toString(nums));
        if(nums.length%2==0)
            return 1.0*(nums[nums.length/2]+nums[nums.length/2-1])/2;
        else
            return 1.0*nums[nums.length/2]/2;

    }
    @Test
    public void test(){
        int[]nums1=new int[]{1,2};
        int[]nums2=new int[]{3,4};
        double ans=findMedianSortedArrays(nums1,nums2);
        System.out.println(ans);
    }
}
