package offertest1;

import org.junit.Test;

public class offer58_2 {
    public String reverseLeftWords(String s, int n) {
        int len=s.length();
        String nn=s.substring(2,len);
        String n1=s.substring(0,2);
        return nn+n1;
    }
    @Test
    public void test(){
        String s=reverseLeftWords("abcdefg",2);
        System.out.println(s);
    }
}
