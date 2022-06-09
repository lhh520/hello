package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 优美的排列II {
    public int[] constructArray(int n, int k) {
        //取k个数 形成4个差值
        int[]nums=new int[n];
        int lo=1,hi=n;
        for(int i=0;i<k;i++){
            nums[i]=i%2==0?lo++:hi--;
        }
        System.out.println(Arrays.toString(nums));
        for(int i=k;i<n;i++) nums[i] = k%2==0? hi-- : lo++;
        return nums;
    }
    @Test
    public void test(){
        constructArray(9,5);
    }
}
