package plan92;
import org.junit.Test;

import java.util.*;
public class 电话号码字母组合 {
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
    public List<String> letterCombinations(String digits){
        backtrace(digits,0);
        return list;
    }
    public void backtrace(String digits,int index){
        if(sb.length()==digits.length()){
            list.add(sb.toString());
            return;
        }
        char c=digits.charAt(index);
        String ss= phoneMap.get(c);
        for(int i=0;i<ss.length();i++){
            sb.append(ss.charAt(i));
            backtrace(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public void test(){
        List<String>list=letterCombinations("23");
        System.out.println(list);
    }
}
