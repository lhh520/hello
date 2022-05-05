package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 拆分数位后四位数字的最小和 {
    public int minimumSum(int num) {
        char[]cc=Integer.toString(num).toCharArray();
        boolean flag=false;
        int[]nums=new int[4];
        for(int i=0;i<cc.length;i++){
            nums[i]=cc[i]-'0';
        }
        Arrays.sort(nums);
        return nums[0]*10+nums[1]*10+nums[2]+nums[3];


    }
    @Test
    public void test(){
        System.out.println(minimumSum(2932));
    }
}
