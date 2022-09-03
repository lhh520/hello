package plan92;

public class 寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int[]nums=new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while (i<nums1.length||j<nums2.length){
            int n1=i>=nums1.length?Integer.MAX_VALUE:nums1[i];
            int n2=j>=nums2.length?Integer.MAX_VALUE:nums2[j];
            if(n1>=n2){
                nums[k++]=n2;
                j++;
            }else {
                nums[k++]=n1;
                i++;
            }
        }
        if(nums.length%2==0){
            return (nums[nums.length/2]+nums[nums.length/2-1])/2.0;
        }else {
            return nums[nums.length/2];
        }
    }
}
