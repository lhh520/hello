package backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test17 {
    public List<String> letterCombinations(String digits) {
        List<String>list=new ArrayList<>();
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
        StringBuilder sb=new StringBuilder();
        backtrace(digits,0,phoneMap,sb,list);
        System.out.println(list.toString());
        return list;
    }
    public void backtrace(String digits,int index,Map<Character, String>map,StringBuilder sb,List<String>list){
        if(index==digits.length()){
           list.add(sb.toString());
           return;
        }else {
        String str=map.get(digits.charAt(index));
        for(int i=0;i<str.length();i++){
             sb.append(str.charAt(i));
             backtrace(digits,index+1,map,sb,list);
             sb.deleteCharAt(sb.length()-1);
        }
        }
    }
    @Test
    public void test(){
        letterCombinations("23");
    }
}
