package test;

import org.junit.Test;

public class 到目标元素的最小距离 {
    public int getMinDistance(int[] nums, int target, int start) {
        int ans=0;
        int i,j;
        int m=Integer.MAX_VALUE,n=Integer.MAX_VALUE;
        for(i=start;i<nums.length;i++){
            if(nums[i]==target){
                m=i;
                break;
            }
        }

        for(j=start;j>=0;j--){
            if(nums[j]==target){
                n=j;
                break;
            }
        }
        return Math.min(Math.abs(start-m),Math.abs(start-n));
    }
    @Test
    public void test(){
        int[]nums =new int[]{5,3,6};
        int target = 5, start = 2;
        System.out.println(getMinDistance(nums,target,start));
    }
}
