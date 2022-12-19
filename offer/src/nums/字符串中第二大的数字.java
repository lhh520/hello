package nums;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class 字符串中第二大的数字 {
    public int secondHighest(String s) {
        char[]chars=s.toCharArray();
        List<Integer>list=new ArrayList<>();
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='0'&&chars[i]<='9'){
                int num=chars[i]-'0';
                if(set.add(num)){
                    list.add(num);
                }

            }
        }
        Collections.sort(list);
        System.out.println(list);
        if(list.size()<=1){
            return -1;
        }else {
            return list.get(list.size()-2);
        }
    }
    @Test
    public void test(){
        String s="dfa12321afd";
        int ret=secondHighest(s);
        System.out.println(ret);
    }
}
