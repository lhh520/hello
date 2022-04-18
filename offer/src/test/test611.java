package test;

import java.util.Arrays;
import java.util.List;

public class test611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        //二重查找和二分法
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++)
            {
                int left=j+1,right=n-1,k=j;
                //k初始化为最左侧，
                while (left<right){
                    int mid=(left+right)/2;
                    if(nums[mid]<nums[i]+nums[j]){
                        k=mid;
                        left=mid+1;
                    }else {
                        right=mid-1;
                    }
                }
                ans+=k-j;
            }
        }
        return ans;
    }
}
