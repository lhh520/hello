package 代码随想录二刷.回溯;
import org.junit.Test;

import java.util.*;
public class 电话号码的字母组合 {
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    StringBuilder sb=new StringBuilder();
    List<String>list=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        char[]chars=digits.toCharArray();
        backtrace(chars,0);
        return list;
    }
    public void backtrace(char[]chars,int index){
        if(sb.length()==chars.length){
            list.add(sb.toString());
            return;
        }
        String strs= phoneMap.get(chars[index]);//当前的数字
        char[]temp=strs.toCharArray();
        for(int i=0;i<temp.length;i++){
            sb.append(temp[i]);
            backtrace(chars,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public void test(){
        String digits="23";
        List<String>list=letterCombinations(digits);
        System.out.println(list.toString());
    }
}
