package offer;

import org.junit.Test;

public class offer13
{
    public int movingCount(int m, int n, int k) {
        char[][]cc=new char[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                cc[i][j]='#';
            }
        }
       return dfs(cc,m,n,k,0,0);

    }
    public int dfs(char[][]cc,int m, int n, int k,int x,int y)
    {
        //System.out.println("ll");
        if(x>=m||y>=n||k<getsum(x)+getsum(y)||cc[x][y]=='*')
            return 0;
        cc[x][y]='*';
        return 1+dfs(cc,m,n,k,x+1,y)+dfs(cc,m,n,k,x,y+1);
    }
    boolean countStr(int x,int y,int k)
    {   int sum1=0;
        while (x!=0)
        {
            sum1=sum1+x%10;
            x=x/10;
        }
        System.out.println(sum1);
        int sum2=0;
        while (y!=0)
        {
            sum2=sum2+y%10;
            y=y/10;
        }
        if(x+y>k)
            return  false;
        else
            return true;
    }
    public int getsum(int x)
    {
        /*int sum=a%10;
        int temp=a/10;
        while (temp>0)
        {
            sum=sum+temp%10;
            temp=temp/10;
        }
        return sum;*/
        int sum1=0;
        while (x!=0)
        {
            sum1=sum1+x%10;
            x=x/10;
        }
        return sum1;
    }
    @Test
    public void test()
    {
        int m = 2, n = 3, k = 1;
        System.out.println(movingCount(m,n,k));
        boolean[] aa=new boolean[2];
        System.out.println(aa[0]);
        System.out.println(getsum(111));
        countStr(111,23,6);
    }
}
