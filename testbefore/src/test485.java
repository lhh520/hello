public class test485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0,maxCount=Integer.MIN_VALUE;
    for(int i=0;i<nums.length;i++)
    {
        if(nums[i]==1)
            count++;
        else
        {
            maxCount=Math.max(maxCount,count);
            count=0;
        }
    }
        maxCount=Math.max(maxCount,count);
    return  maxCount;
    }
}
