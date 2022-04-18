import org.junit.Test;

public class test80 {
    /*
输入：nums = [1,1,1,2,2,3]
输出：5, nums = [1,1,2,2,3]
*/
    public int removeDuplicates(int[] nums) {
       int n=nums.length;
       if(n<2)
           return n;
       int slow=2,fast=2;
       while (fast<n)
       {
           if(nums[slow-2]!=nums[fast])
           {
               nums[slow]=nums[fast];
               ++slow;
           }
           ++fast;
       }
       return slow;
    }
    @Test
    public void test()
    {
        int[] num=new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(num));
    }
}
