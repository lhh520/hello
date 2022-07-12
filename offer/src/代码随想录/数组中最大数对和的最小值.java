package 代码随想录;

import org.junit.Test;

import java.util.Arrays;

public class 数组中最大数对和的最小值 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int[]temp=new int[nums.length];
        int i=0,j=nums.length-1,k=0;
        boolean flag=true;
        while (i<=j){
            if(flag){
            temp[k++]=nums[i++];
             flag=false;
            }else {
                temp[k++]=nums[j--];
                flag=true;
            }
        }
        System.out.println(Arrays.toString(temp));
        i=0;
        j=nums.length-1;
        int max=Integer.MIN_VALUE;
        for(int ii=0;ii< nums.length-1;ii+=2){
            max=Math.max(max,temp[ii]+temp[ii+1]);
        }
        return max;
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,5,4,2,4,6};
        System.out.println(minPairSum(nums));
    }
}
