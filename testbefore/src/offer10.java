import org.junit.Test;

public class offer10 {
    public int numWays(int n)
    {
        return dfs(n)%1000000008;
    }
    public int dfs(int n)
    {
       if(n==0||n==1)
           return 1;
       else
       return dfs(n-1)+dfs(n-2);
    }
    public int numWays1(int n)
    {
        int a=1,b=1,sum;
        for(int i=0;i<n;i++)
        {
            sum=(a+b)%1000000008;
            a=b;
            b=sum;
        }
        return a;
    }
    @Test
    public void test()
    {
        int n=7;
        System.out.println(numWays(n));
    }
}
