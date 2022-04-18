import org.junit.Test;

public class test507 {
    public boolean checkPerfectNumber(int num) {
        int sum=0;
    for(int i=1;i<=num/2;i++)
    {
        if(num%i==0)
        {   sum=sum+i;

        }
    }
    if(sum==num)
        return true;
    else
        return false;
    }
    @Test
    public void test()
    {
        System.out.println(checkPerfectNumber(8128));
    }
}
