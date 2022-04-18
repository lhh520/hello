package offer;

import org.junit.Test;

import java.util.Arrays;

public class offer39 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    @Test
    public  void test()
    {
        int[] nn=new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nn));
    }
}
