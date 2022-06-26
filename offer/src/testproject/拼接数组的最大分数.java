package testproject;

import org.junit.Test;

public class 拼接数组的最大分数 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(solve(nums1,nums2),solve(nums2,nums1));
    }
    public int solve(int[]nums1,int[]nums2){
        int[]diff=new int[nums1.length];
        int s=0;
        for(int i=0;i<nums1.length;i++){
            diff[i]=nums2[i]-nums1[i];
            s+=nums1[i];
        }
        int max=0;
        int sum=0;
        for(int i=0;i<diff.length;i++){
            if(sum+diff[i]<0){
                sum=0;
            }else {
                sum+=diff[i];
            }
            max=Math.max(max,sum);
        }
        return s+max;
    }
    @Test
    public void test(){
        int[]nums1 =new int[]{60,60,60};
        int[]nums2 =new int[]{10,90,10};
        System.out.println(maximumsSplicedArray(nums1,nums2));
    }
}
