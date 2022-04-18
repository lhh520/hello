import org.junit.Test;

public class test1221 {
    public int balancedStringSplit(String s) {
        char[] ss=s.toCharArray();
        int n=ss.length;
        int count=0,count1=0;
        int sum=0;
    for(int i=0;i<n;i++)
    {
        if(ss[i]=='R')
            count++;
        if(ss[i]=='L')
            count1++;
        if(count==count1)
        {
            sum++;
            count=0;
            count1=0;
        }
    }
       // System.out.println(sum);
        return sum;
    }
    @Test
    public void test()
    {
        String ans="RLLLLRRRLR";
        System.out.println(balancedStringSplit(ans));
    }
}
