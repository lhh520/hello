package offer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class offer48 {
    public int lengthOfLongestSubstring(String s) {

    char[]temp=s.toCharArray();
    Set<Character>set=new HashSet<>();
    int i=0,j=0;
    int maxLen=Integer.MIN_VALUE;
    while (j<temp.length)
    {
        if(set.add(temp[j]))
        {
            j++;
        }
        else
        {
            set.remove(temp[i]);
            i++;
        }
        maxLen=Math.max(maxLen,j-i);
    }
    return maxLen;
    }



    @Test
    public void test()
    {
        String nn="bbbb";//"pwwkew";
        System.out.println(lengthOfLongestSubstring(nn));
    }
}
