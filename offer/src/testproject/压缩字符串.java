package testproject;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 压缩字符串 {
    public int compress(char[] chars) {
        int cnt=1;
        for(int i=1;i<chars.length;i++){
            int num=0;
            while (i<chars.length&&chars[i]==chars[i-1]){
                num++;
                i++;
            }
            if(num>0){
                String cur=Integer.toString(num);
                System.out.println(cur);
                cnt+=cur.length();
            }
        }
        return cnt;
    }
    public int compress1(char[] chars){
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<chars.length;i++){
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }
        int cnt=0;
        for(Map.Entry<Character,Integer>entry:map.entrySet()){
            if(entry.getValue()==1){
                cnt+=1;
            }else {
                String c=Integer.toString(entry.getValue());
                cnt=cnt+1+c.length();
            }
        }
        return cnt;
    }
    @Test
    public void test(){
        char[]chars=new char[]{'a','a','b','b','c','c','c'};
        System.out.println(compress1(chars));
    }
}
