import org.junit.Test;

public class test453 {
    public int minMoves(int[] nums) {
        int sum=0,min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            min=Math.min(nums[i],min);
        }
        return sum-min*(nums.length);
    }
    public int minMoves1(int[] nums)
    {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            min=Math.min(min,nums[i]);
        }
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i]-min;
        }
        return sum;
    }
    @Test
    public void test()
    {
        int[] nums=new int[]{1,2,3};
        System.out.println(minMoves(nums));
    }
}
