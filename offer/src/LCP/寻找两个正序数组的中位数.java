package LCP;

import org.junit.Test;

public class 寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[]num=new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while (i<nums1.length||j<nums2.length){
            int m=i>=nums1.length?Integer.MAX_VALUE:nums1[i];
            int n=j>=nums2.length?Integer.MAX_VALUE:nums2[j];
            if(m>=n){
                num[k++]=n;
                j++;
            }else {
                num[k++]=m;
                i++;
            }
        }
        int len=nums1.length+nums2.length;
        if(len%2==0){
            return (num[len/2]+num[len/2-1])/2.0;
        }else {
            return num[len/2]*1.0;
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,3};
        int[]nums2=new int[]{2};
        System.out.println(findMedianSortedArrays(nums,nums2));
    }
}
