package 代码随想录;

import org.junit.Test;

public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums){
        int len=1,n=nums.length;
        if(n==0){
            return 0;
        }
        int[]d=new int[n+1];
        d[len]=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>d[len]){
                d[++len]=nums[i];
            }else {
                int l=1,r=len,pos=0;
                while (l<=r){
                    int mid=(i+r)/2;
                    if(d[mid]<nums[i]){
                        pos=mid;
                        l=mid+1;
                    }else {
                        r=mid-1;
                    }
                }
                d[pos+1]=nums[i];
            }
        }
        return len;
    }
    @Test
    public void test(){
        int[]nums =new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
