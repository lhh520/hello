import org.junit.Test;

public class test492
{
    public int[] constructRectangle(int area) {
        int min=Integer.MAX_VALUE;
        int ans=-1;
    for(int i=1;i<=area;i++)
    {
        if(i*(area/i)==area&&i>=(area/i))
        {//min=Math.min(i-area/i,min);
         //   ans=i;
            if(i-area/i<min)
            {
                min=i-area;
                ans=i;
            }
        }
    }
    return new int[]{ans,area/ans};
    }
    @Test
    public void test()
    {
        int area=4;
        int[] nums=constructRectangle(122122);
        System.out.println(nums[0]+"ccf"+nums[1]);
    }
}
