import org.junit.Test;

public class test172 {
    public int trailingZeroes(int n) {
        int cur=1;
        int count=0;
    for(int i=n;i>=1;i--)
    {   cur=cur*i;
        if(cur%10==0)
        {
           count++;
           cur=cur/10;
        }
    }
    return count;
    }
    @Test
    public void test()
    {
        int n=6;
        System.out.println(trailingZeroes(n));
    }
}
