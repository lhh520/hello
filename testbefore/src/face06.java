import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class face06 {
    public String compressString(String S) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<S.length();i++)
        {
            map.put(S.charAt(i),map.getOrDefault(S.charAt(i),0)+1);
        }
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<Character,Integer>entry: map.entrySet())
        {
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
        String temp=sb.toString();
        return temp.length()<S.length()?temp:S;
    }
    public String compressString1(String S)
    {   StringBuilder sb=new StringBuilder();

        char ch=S.charAt(0);
        int cnt=1;
        for(int i=1;i<S.length();i++)
        {   if(ch==S.charAt(i))
            cnt++;
            else
        {
            sb.append(ch);
            sb.append(cnt);
            cnt=1;
            ch=S.charAt(i);
        }
        }
        sb.append(ch);
        sb.append(cnt);
        return sb.length()>=S.length()?S:sb.toString();
    }
    @Test
    public void test()
    {
        String S="aabcccccaaa";
        System.out.println(compressString1(S));
    }
}
