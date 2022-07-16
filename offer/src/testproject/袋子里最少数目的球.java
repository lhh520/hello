package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 袋子里最少数目的球 {
    public int minimumSize(int[] nums, int maxOperations) {
        int left=1,right= Arrays.stream(nums).max().getAsInt();
        while (left<right){
            int mid=(left+right)/2;
            if(operateTimes(nums,mid)<=maxOperations){//表示操作数小于给定数字，争取的mid在左边 可以增大操的数字
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
    public int operateTimes(int[]nums,int x){//表示最大的长度为x的操作次数
        int times=0;
        for(int n:nums){
            times+=(n-1)/x;
        }
        return times;
    }
    @Test
    public void test(){
        //nums = [2,4,8,2], maxOperations = 4
        int[]nums=new int[]{2,4,8,2};
        System.out.println(minimumSize(nums,4));
    }
}
