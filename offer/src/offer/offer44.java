package offer;

import org.junit.Test;

public class offer44 {
    public int findNthDigit(int n) {
    StringBuilder sb=new StringBuilder();
    for(int i=0;i<=n;i++)
    {
        sb.append(Integer.toString(i));
    }
    String s=sb.toString();
    //System.out.println(s);
        return sb.toString().charAt(n)-'0';
    }
    @Test
    public void test()
    {
        int n=3;
        System.out.println(findNthDigit(n));
    }
}
