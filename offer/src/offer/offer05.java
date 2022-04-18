package offer;

import org.junit.Test;
import org.omg.CORBA.MARSHAL;

public class offer05 {
    public int maxProduct(String[] words) {
        int max=Integer.MIN_VALUE;
    for(int i=0;i<words.length-1;i++)
    {
        for(int j=i+1;j<words.length;j++)
        {
            if(nosame(words[i],words[j]))
            {
                System.out.println(words[i]+"   "+words[j]);
                max=Math.max(max, words[i].length()*words[j].length());
            }
        }
    }
    return  max;
    }
    public boolean nosame(String s1,String s2)
    {
        char[] chars=s2.toCharArray();
        for(int i=0;i<s1.length();i++)
        {
            if(s2.indexOf(s1.charAt(i))!=-1)
                return false;
        }
        return true;
    }
    @Test
    public void test()
    {   String[] anss=new String[]{"a","ab","abc","d","cd","bcd","abcd"};
        String[] ans=new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(anss));
    }
}
