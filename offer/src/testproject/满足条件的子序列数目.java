package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 满足条件的子序列数目 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int mod=1000000007;
        int[]tmp=new int[n];
        tmp[0]=1;
        for(int i=1;i<n;i++){
            tmp[i]=(tmp[i-1]<<1)%mod;
        }
        System.out.println(Arrays.toString(tmp));
        int res=0;
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            if(nums[l]+nums[r]>target){
                r--;
            }else {
                res=(res+tmp[r-l])%mod;
                l++;
            }
        }
        return res;
    }
    @Test
    public void test(){
        int[]nums =new int[]{3,5,6,7};
        int target = 9;
        System.out.println(numSubseq(nums,target));
    }
}
