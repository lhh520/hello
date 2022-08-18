package hot100;

import org.junit.Test;

public class 寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //双指针
        int m=nums1.length,n=nums2.length;
        int[]target=new int[m+n];
        int i=0,j=0,k=0;
        while (i<m||j<n){
            int t1=i==m?Integer.MAX_VALUE:nums1[i];
            int t2=j==n?Integer.MAX_VALUE:nums2[j];
            if(t1>t2){
                target[k++]=t2;
                j++;
            }else {
                target[k++]=t1;
                i++;
            }

        }
        if(target.length%2==0){
            return (target[target.length/2]+target[target.length/2-1])/2.0;
        }else {
            return target[target.length/2];
        }
    }
    @Test
    public void test(){
        int[]nums1 =new int[]{1,3};
        int[]nums2 =new int[]{2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
