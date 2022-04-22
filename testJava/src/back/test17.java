package back;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test17 {
    StringBuffer sb=new StringBuffer();
    List<String>list=new ArrayList<>();
    public List<String> letterCombinations(String digits){
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
        backtrace(digits,phoneMap,0);
        return list;
    }
    public void backtrace(String digits,Map<Character, String> phoneMap,int index){
        if(index==digits.length()){
            String temp=new String(sb);
            list.add(temp);
            return;
        }
        //每一层遍历
        String s= phoneMap.get(digits.charAt(index));
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            backtrace(digits,phoneMap,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public void test(){
        List<String>qw=letterCombinations("23");
        for(String s:qw){
            System.out.println(s);
        }
    }
}
