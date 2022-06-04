package test;

import org.junit.Test;

import java.util.Stack;

public class 比较含退格的字符串 {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>set=new Stack<>();
        Stack<Character>set2=new Stack<>();
        int i=0,j=0;
        while (i<s.length()){
            if(s.charAt(i)!='#'){
                set.add(s.charAt(i));
                i++;
            }else {
            while (i<s.length()&&s.charAt(i)=='#'){
                if(!set.isEmpty()){
                    set.pop();
                    i++;
                }
            }}
        }
        //
        while (j<t.length()){
            if(t.charAt(j)!='#'){
                set2.add(t.charAt(j));
                j++;
            }else {
            while (j<t.length()&&t.charAt(j)=='#'){
                if(!set2.isEmpty()){
                    set2.pop();
                }
                j++;
            }}
        }
        return set.equals(set2);
    }
    @Test
    public void test(){

        String s = "xywrrmp", t = "xywrrmu#p";
        System.out.println(backspaceCompare(s,t));
    }
}
