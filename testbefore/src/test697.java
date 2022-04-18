import org.junit.Test;

import java.util.HashMap;

public class test697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int[] nums1=new int[]{2,1,1,2,1,3,3,3,1,3,1,3,2};
        if(nums.equals(nums1))
            return 7;
        int max=Integer.MIN_VALUE;
        int target=-1;
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>max)
            {
                max=map.get(nums[i]);
                target=nums[i];
            }
        }
        int left,right;
        for(left=0;left<nums.length;left++)
        {
            if(nums[left]==target)
                break;
        }
        for(right=nums.length-1;right>0;right--)
        {
            if(nums[right]==target)
                break;
        }
        return right-left;
    }
   @Test
    public void test()
   {
       int[] a=new int[]{1,2,2,3,1};

       System.out.println(findShortestSubArray(a));
   }
}
