package 新刷题;
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
    List<String>lists=new ArrayList<>();
    StringBuffer sb=new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return lists;
        }
        //回溯方法 找到所有的组合
        backtrance(digits,0);
        return lists;
    }
    public void backtrance(String digits,int index){
        if(digits.length()==sb.length()){
            lists.add(sb.toString());
            return;
        }
        String cur= phoneMap.get(digits.charAt(index));
        for(int i=0;i<cur.length();i++){
            sb.append(cur.charAt(i));
            backtrance(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public void test(){
        String digits = "23";
        List<String>str=letterCombinations(digits);
        System.out.println(str.toString());
    }
}
