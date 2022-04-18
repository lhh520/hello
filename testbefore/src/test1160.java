import org.junit.Test;

import java.util.Arrays;

public class test1160 {
    public int countCharacters(String[] words, String chars) {
        int[] check=new int[26];
        for(int i=0;i<chars.length();i++)
        {
            check[chars.charAt(i)-'a']++;
        }
        int sum=0;
    for(int i=0;i<words.length;i++)
    {
        int[] temp=new int[26];
        System.arraycopy(check,0,temp,0,temp.length);
        int flag=1;
        for(int j=0;j<words[i].length();j++)
        {
            temp[words[i].charAt(j)-'a']--;
            if(temp[words[i].charAt(j)-'a']<0)
                flag=0;
        }
        if(flag==1)
           sum=sum+words[i].length();
    }
    return  sum;
    }
    @Test
    public void test()
    {
        String[] words =new String[]{"cat","bt","hat","tree"};
        String kk="atach";
        System.out.println(countCharacters(words,kk));
    }
}
