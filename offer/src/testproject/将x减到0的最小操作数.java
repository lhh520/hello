package testproject;

import java.util.Arrays;

public class 将x减到0的最小操作数 {
    public int minOperations(int[] nums, int x) {
        int maxPart=-1;
        int sum=Arrays.stream(nums).sum();
        int currentSum=0;
        int left=0,right=0;
        while (left< nums.length){
            if(right< nums.length){
                currentSum+=nums[right++];
            }
            while(currentSum>sum-x&&left<nums.length){
                currentSum-=nums[left++];
            }
            if(currentSum==sum-x){
                maxPart=Math.max(maxPart,right-left);//让左右尽量的短  就是中间的值尽量的大
            }
            if(right==nums.length){
                left++;
            }
        }
        return maxPart==-1?-1: nums.length-maxPart;
    }
    public int maxScore(int[]cardPoints,int k){//滑动窗口
        int n=cardPoints.length;
        int[]window=new int[n-k];
        int sum=0;
        for(int i=0;i<window.length;i++){
            sum+=window[i];
        }
        int miniSum=sum;
        for(int i= window.length;i<cardPoints.length;i++){
            sum+=cardPoints[i]-cardPoints[i-(n-k)];
            miniSum=Math.min(miniSum,sum);
        }
        return Arrays.stream(cardPoints).sum()-miniSum;
    }
}
