import org.junit.Test;

public class test162 {
    public int findPeakElement(int[] nums) {
        int sz=nums.length;
        if(nums[0]>nums[1])
            return 0;
        if(nums[sz-2]<nums[sz-1])
            return sz-1;
        for(int i=1;i<=sz-2;i++)
        {
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1])
                return i;
        }
        return -1;
    }
    @Test
    public void test()
    {
        //nums = [1,2,1,3,5,6,4]
        //[1,2,3,1]
        int[] nums=new int[]{1,2,3,1};
        System.out.println(findPeakElement(nums));
    }
}
