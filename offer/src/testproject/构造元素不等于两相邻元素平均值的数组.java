package testproject;

import java.util.Arrays;

public class 构造元素不等于两相邻元素平均值的数组 {
    public int[] rearrangeArray(int[] nums) {
        //中间是两者中的最大值
        Arrays.sort(nums);
        int n=nums.length;
        int r=n-1;
        int l=0;
        int[]res=new int[n];
        for(int i=0;i<n;i++){
            if(i%2==1){
                res[i]=nums[r];
                r--;
            }else {
                res[i]=nums[l];
                l++;
            }
        }
        return res;
    }
}
