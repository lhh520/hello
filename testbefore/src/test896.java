public class test896 {
    public boolean isMonotonic(int[] nums) {
        if(nums.length==1||nums.length==0)
            return true;
        if(nums[0]>nums[1])
        {
            for(int i=0;i<nums.length-1;i++)
            {
                if(nums[i]<nums[i+1])
                    return false;
            }
            return true;
        }
        else
        {
            for(int i=0;i<nums.length-1;i++)
            {
                if(nums[i]>nums[i+1])
                    return false;
            }
            return true;
        }
    }
}
