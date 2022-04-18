import org.junit.Test;

public class test482 {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-","").toUpperCase();
        StringBuilder str=new StringBuilder();
        int j=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            str.append(s.charAt(i));
            j++;
            if(j==k&&i!=0)
            {
                str.append("-");
                j=0;
            }
        }

        return str.reverse().toString();
    }
    @Test
    public void test()
    {   String S = "2-5g-3-J";
        System.out.println(licenseKeyFormatting(S,2));
    }
}
