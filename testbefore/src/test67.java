import org.junit.Test;

public class test67 {
    public String addBinary(String a, String b) {
    StringBuilder sb=new StringBuilder();
    int alen=a.length()-1;
    int blen=b.length()-1;
    char carry='0';
        //System.out.println("hello");
    while(alen>=0||blen>=0||carry=='1')
    {
        char aa=alen<0?'0':a.charAt(alen);
        char bb=blen<0?'0':b.charAt(blen);
        if(carry=='1')
        {
            if(aa=='1'&&bb=='1')
            {
                sb.append('1');
                carry='1';
            }
            else if(aa=='0'&&bb=='0')
            {
                sb.append('1');
                carry='0';
            }
            else
            {
                sb.append('0');
                carry='1';
            }

        }
        else
        {
            if(aa=='1'&&bb=='1')
            {
                sb.append('0');
                carry='1';
            }
            else if(aa=='0'&&bb=='0')
            {
                sb.append('0');
                carry='0';
            }
            else
            {
                sb.append('1');
                carry='0';
            }
        }
        alen--;
        blen--;
    }
    return sb.reverse().toString();
    }
    @Test
    public void test()
    {
        String a = "1010", b = "1011";
        System.out.println(addBinary(a,b));
    }
}
