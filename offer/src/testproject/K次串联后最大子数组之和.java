package testproject;

import org.junit.Test;

public class K次串联后最大子数组之和 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        //先求累计最大和
        int base = 1000000007;
        long maxSum=0;
        long curSum=0;
        long arrSum=0;
        for(int i=0;i<arr.length;i++){//求的第一个最大值
            arrSum+=arr[i];
            curSum=Math.max(curSum+arr[i],arr[i]);
            maxSum=Math.max(maxSum,curSum);
        }
        if(k==1){
            return (int) (maxSum%base);
        }
        System.out.println(maxSum);
        //第二个最大值
        long maxSum2=maxSum;
        for(int i=0;i<arr.length;i++){//求的第一个最大值
            curSum=Math.max(curSum+arr[i],arr[i]);
            maxSum2=Math.max(maxSum2,curSum);
        }
        System.out.println(maxSum2);
        if(k==2){
            return (int) Math.max(maxSum%base,maxSum2%base);
        }
        //第三个最大值
        long maxSum3=((maxSum2%base+((k-2)*arrSum)%base)%base);

        return (int) (Math.max(Math.max(maxSum%base,maxSum2%base),maxSum3%base)%base);
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,-5,1,0,-2,-2,2};
        System.out.println(kConcatenationMaxSum(nums,2));
    }
}
