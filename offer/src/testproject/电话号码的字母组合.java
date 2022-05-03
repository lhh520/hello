package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {
    StringBuffer sb=new StringBuffer();
    List<String> list=new ArrayList<>();
    public List<String> letterCombinations(String digits){
        if(digits.length()==0)
            return list;
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
            list.add(sb.toString());
            return;
        }
            String temp=phoneMap.get(digits.charAt(index));
            for(int j=0;j<temp.length();j++){
                sb.append(temp.charAt(j));
                backtrace(digits,phoneMap,index+1);
                sb.deleteCharAt(sb.length()-1);
            }
    }
    @Test
    public void test(){
        System.out.println(letterCombinations("23").toString());
    }
}
