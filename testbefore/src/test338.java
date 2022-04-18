import org.junit.Test;

import java.util.Arrays;

public class test338 {
    public int[] countBits(int n) {
    int[] bitcount=new int[n+1];
    for(int i=0;i<=n;i++)
    {
        bitcount[i]=count(i);
    }
    return bitcount;
    }
    public int count(int x)
    {   int num=0;
        while(x!=0)
        {
            x=x&(x-1);
            num++;
        }
        return  num;
    }
    @Test
    public void test()
    {
        int[] bitcount=countBits(5);
        System.out.println(Arrays.toString(bitcount));
    }
}
