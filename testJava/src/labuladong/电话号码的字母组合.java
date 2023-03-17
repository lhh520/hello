package labuladong;
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
    List<String>ans=new ArrayList<>();
    StringBuffer sb=new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return ans;
        }
        char[]chars=digits.toCharArray();
        backtrace(chars,0);
        return ans;
    }
    public void backtrace(char[]chars,int index){
        if(index==chars.length){
            ans.add(new String(sb.toString()));
            return;
        }
        char c=chars[index];
        char[] str=phoneMap.get(c).toCharArray();
        for(char cc:str){
            sb.append(cc);
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
