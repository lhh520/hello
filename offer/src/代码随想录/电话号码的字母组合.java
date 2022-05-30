package 代码随想录;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //digits = "23"
        if(digits.length()==0){
            return list;
        }
        dfs(digits,0);
        return list;
    }
    public void dfs(String digits,int index){
        if(index==digits.length()){
            list.add(sb.toString());
            return;
        }
        String ss=phoneMap.get(digits.charAt(index));
        for(char c:ss.toCharArray()){
            sb.append(c);
            dfs(digits,index+1);
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
