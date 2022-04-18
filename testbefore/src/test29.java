import org.junit.Test;

public class test29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(divisor == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE)
            return 1;
        if(divisor == Integer.MIN_VALUE)
            return 0;
        int flag=0;
        if(dividend<0) {dividend=-dividend;
        flag++;}
        if(divisor<0) {divisor=-divisor;
        flag++;}
        int count=0;
        while(dividend>0)
        {
            dividend=dividend-divisor;
            count++;
        }
        if(dividend<0)
            count--;
        if(flag%2==0)
        return count;
        else return -count;
    }
    @Test
    public void test()
    {
        int dividend = 10, divisor = 3;
        System.out.println(divide(10,-3));
    }
}
