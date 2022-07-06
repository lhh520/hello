package test;

public class 最少交换次数来组合所有的II {
    public int minSwaps(int[] nums) {
        int count=0,ans=0,num=0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
        }
        for(int i=0;i<count;i++){
            num+=nums[i];
        }
        ans=num;
        for(int i=0;i<nums.length;i++){
            num+=nums[(count+i)%nums.length]-nums[i];
            ans=Math.max(ans,num);
        }
        return count-ans;
    }
}
