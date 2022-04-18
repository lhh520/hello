package offer;

import org.junit.Test;

public class offer43 {
    public int countDigitOne(int n) {
        int sum=0;
    for(int i=1;i<=n;i++)
    {
        String temp=Integer.toString(i);
        sum=sum+countzeros(temp);
    }
    return sum;
    }
    int countzeros(String temp)
    {
        int count=0;
        for(int i=0;i<temp.length();i++)
        {
            if(temp.charAt(i)=='1')
                count++;
        }
        return count;
    }
    @Test
    public  void  test()
    {
        System.out.println(countDigitOne(13));
    }
}
