package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 特殊数组的特征值 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0,r=n;
        while (l<=r){
            int x=(l+r)/2;
            int idx=binarySearch(nums,x);
            if(x==n-idx){//恰好剩余x大于x
                return x;
            }else if(x<n-idx){
                l=x+1;
            }else {
                r=x-1;
            }
        }
        return -1;
    }
    public int binarySearch(int[]nums,int x){
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            int val=nums[mid];
            if(val>=x){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return l;
    }
    @Test
    public void test(){
        int[]nums =new int[]{3,5};
        System.out.println(specialArray(nums));
    }
}
