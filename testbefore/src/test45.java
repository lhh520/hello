import org.junit.Test;

public class test45
{
    public int jump(int[] nums) {
    int position=nums.length-1;
    int steps=0;
    while(position!=0)
    {
        for(int i=0;i<position;i++)
        {
            if(i+nums[i]>=position)
            {
                steps++;
                position=i;
                break;
            }
        }
    }
    return steps;
    }
    @Test
    public void test()
    {
        int[] nums=new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
