package 代码随想录二刷.数组;

import java.util.Arrays;

public class 比较含退格的字符串 {
    public int[] sortedSquares(int[] nums) {
        int len=nums.length;
        int[]newnums=new int[len];
        for(int i=0;i<len;i++){
            newnums[i]=nums[i]*nums[i];
        }
        Arrays.sort(newnums);
        return newnums;
    }
    public int[] sortedSquares1(int[] nums){
        int l=0;
        int r=nums.length-1;
        int[]res=new int[nums.length];
        int j=nums.length-1;
        while (l<r){
            if(nums[l]*nums[l]>nums[r]*nums[r]){
                res[j--]=nums[l++];
            }else {
                res[j--]=nums[r--];
            }
        }
        return res;
    }
}
