import org.junit.Test;

public class offer61 {
    public boolean isStraight(int[] nums)
    {
        int[]buck=new int[14];
        int min=14;
        int max=0;
        int zeros=0;
        //System.out.println("fvf");
        for(int n:nums)
        {
            if(n==0)
            {
                zeros++;
                continue;
            }
            buck[n]++;//为当前的增加1
            if(buck[n]>1)//说明当前有重复的，则一定不可能有
            {
               return false;
            }
            //计数的是除了0之外的比较大的数字
            max=Math.max(max,n);
            min=Math.min(n,min);
        }
        for(int i=min;i<max;i++)
        {
            if(buck[i]==0)
                zeros--;
        }
        return zeros>=0;
    }
    @Test
    public void test()
    {
        int[] nums=new int[]{1,2,3,4,5};
        System.out.println(isStraight(nums));
    }
}
