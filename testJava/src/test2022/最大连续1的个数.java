package test2022;

import org.junit.Test;

import java.util.Arrays;

public class 最大连续1的个数 {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int[]P=new int[n+1];
        for(int i=1;i<=n;i++){
            P[i]=P[i-1]+(1-nums[i-1]);
        }
        System.out.println(Arrays.toString(P));
        int ans=0;
        for(int right=0;right<n;right++){
            int left=binarySearch(P,P[right+1]-k);
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
    public int binarySearch(int[]P,int target){
        int low=0,high=P.length-1;
        while (low<=high){
            int mid=(high+low)/2;
            if(P[mid]<target){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return low;
    }
    @Test
    public void test(){
        //nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
        int[]nums=new int[]{1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums,2));
    }
}
