package test;

import org.junit.Test;

import java.util.Arrays;

public class 移除石子的最大得分 {
    public int maximumScore(int a, int b, int c) {
        int[]nums=new int[3];
        nums[0]=a;
        nums[1]=b;
        nums[2]=c;
        Arrays.sort(nums);
        int res=0;
        while(nums[0]+nums[1]>nums[2]){
            nums[0]--;
            nums[1]--;
            res++;
        }
        res+=nums[1]+nums[0];
        return res;
    }
    @Test
    public void test(){
        int a = 2, b = 4, c = 6;
        System.out.println(maximumScore(a,b,c));
    }
}
