import org.junit.Test;

import java.util.Arrays;

public class test1479 {
    public int[] shuffle(int[] nums, int n) {
        int[] newnum=new int[2*n];
        for(int i=0;i<n;i++)
        {
            newnum[i*2]=nums[i];

        }
        for(int i=0;i<n;i++)
        {
            newnum[2*i+1]=nums[i+n];

        }
        return newnum;
    }
    @Test
    public void test()
    {
        int[]nums = new int[]{2,5,1,3,4,7};
        int n=3;
        System.out.println(Arrays.toString(shuffle(nums,n)));
    }
}
