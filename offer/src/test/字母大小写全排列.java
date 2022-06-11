package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 字母大小写全排列 {
    //输入：s = "a1b2"
    //输出：["a1b2", "a1B2", "A1b2", "A1B2"]
    StringBuilder sb=new StringBuilder();
    List<String>list=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        backtrace(s,0);
        return list;
    }
    public void backtrace(String s,int index){
        if(index==s.length()){
            list.add(sb.toString());
            return;
        }
        if(s.charAt(index)>='0'&&s.charAt(index)<='9'){
            sb.append(s.charAt(index));
            backtrace(s,index+1);
            sb.deleteCharAt(sb.length()-1);
        }else {
            sb.append(s.charAt(index));
            backtrace(s,index+1);
            sb.deleteCharAt(sb.length()-1);
            //
            if(s.charAt(index)>='a'&&s.charAt(index)<='z'){
                sb.append((char)(s.charAt(index)-32));
            }else {
                sb.append((char)(s.charAt(index)+32));
            }

            backtrace(s,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public void test(){
        String s = "3z4";
        List<String>li=letterCasePermutation(s);
        System.out.println(li.toString());
    }
}
