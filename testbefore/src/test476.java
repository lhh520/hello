import org.junit.Test;

public class test476 {
    public int findComplement(int num) {
        int highbit=0;
        for(int i=0;i<=30;i++)
        {
            if(num>=1<<i)
                highbit=i;
            else
                break;
        }
        int mask=highbit==30?0xfffffff:(1<<(highbit+1))-1;
        return mask^num;
    }
    @Test
    public void test()
    {
        int num=5;
        System.out.println(findComplement(num));
    }
}
