import org.junit.Test;

public class test434 {
    public int countSegments(String s) {
        /*if(s=="")
            return 0;
        String[] str=s.split(" ");
        return str.length;*/
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if((i==0||s.charAt(i-1)==' ')&&s.charAt(i)!=' ')
                count++;
        }
        return count;
    }
    @Test
    public void test()
    {
        String ans="hello, wo";
        System.out.println(countSegments(ans));
    }
}
