import org.junit.Test;

public class test1342 {
    public int numberOfSteps(int num) {
        int count=0;
    while (num!=0)
    {
        if(num%2==0)
        {
            count++;
            num=num/2;
        }
        else
        {
            count++;
            num--;
        }
    }
    return count;
    }
    @Test
    public void test()
    {
        int bb=numberOfSteps(14);
        System.out.println(bb);
    }
}
