import java.util.HashMap;

public class offer16
{
    public int lengthOfLongestSubstring(String s) {
       int res=0;
       int start=0;
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            //已经出现了重复数字，有两种选择，更新此时的
            if(map.containsKey(c))
            {
                start=Math.max(map.get(c)+1,start);

            }
            map.put(c,i);
            res=Math.max(res,i-start+1);
        }
        return res;
    }
}
