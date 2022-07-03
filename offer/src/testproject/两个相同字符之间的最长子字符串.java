package testproject;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 两个相同字符之间的最长子字符串 {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character,Integer>map=new HashMap<>();
        int ret=-1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                ret=Math.max(ret,i-map.get(c)-1);
            }else {
                map.put(c,i);
            }
        }
        return ret;
    }
    @Test
    public void test(){
        String s = "cabbac";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }
}
