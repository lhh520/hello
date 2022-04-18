import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test557 {
    public String reverseWords(String s) {
    String[] str=s.split(" ");
    StringBuilder sb=new StringBuilder();
    for(int i=0;i<str.length;i++)
    {   char[]arr=str[i].toCharArray();
        int len=arr.length;
        for(int j=0;j<len/2;j++)
        {
            char temp=arr[j];
            //str.=str[]
            arr[j]=arr[len-1-j];
            arr[len-1-j]=temp;
        }
        for(int j=0;j<len;j++)
        {
            sb.append(arr[j]);
        }
        //sb.append(Arrays.toString(arr));
        if(i!=str.length-1)
            sb.append(" ");
    }
     return sb.toString();
    }

    @Test
    public void test()
    {
        String s="Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
