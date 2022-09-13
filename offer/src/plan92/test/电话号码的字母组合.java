package plan92.test;
import org.junit.Test;

import java.util.*;
public class 电话号码的字母组合 {
    List<String>list=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
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
    public List<String> letterCombinations(String digits){
        if(digits.length()==0){
            return list;
        }
        backtrace(digits,0);
        return list;
    }
    public void backtrace(String digits,int index){
        if(index==digits.length()) {
            list.add(sb.toString());
            return;
        }
        //开始回溯
        String str= phoneMap.get(digits.charAt(index));
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            sb.append(c);
            backtrace(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public void test(){
        String digits = "23";
        List<String>list=letterCombinations(digits);
        System.out.println(list);
    }

}
