import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class test290 {
    public boolean wordPattern(String pattern, String s) {
    Map<Character,String> map=new HashMap<>();
    String[] strs=s.split(" ");
    int len=strs.length;
    if(pattern.length()!=len)
        return false;
    for(int i=0;i<len;i++)
    {
        char c=pattern.charAt(i);//取到模式进行匹配
        if(!map.containsKey(c))
        {
            if(map.containsValue(strs[i]))
                map.put(c,strs[i]);
            else
                return false;
        }
        else if(!map.get(c).equals(strs[i]))
            return false;
    }
    return true;
    }
    @Test
    public void test()
    {

    }
}
