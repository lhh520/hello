package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 通过删除字母匹配到字典里最长单词 {
    public String findLongestWord(String s, List<String> dictionary) {
        String ret="";
        int len=0;
        for(int i=0;i<dictionary.size();i++){
            String cur=dictionary.get(i);
            int m=0,n=0;
            while (m<s.length()&&n<cur.length()){
                if(s.charAt(m)==cur.charAt(n)){
                    m++;
                    n++;
                }else {
                    m++;
                }
            }
            System.out.println(1);
            if(n==cur.length()){
                if(ret.length()<=0){
                    len=cur.length();
                    ret=cur;
                }
                else if(len<cur.length()||(len==cur.length()&&cur.compareTo(ret)<0)){
                    len=cur.length();
                    ret=cur;
                }
            }
        }
        return ret;
    }
    @Test
    public void test(){
        //"abce"
        //["abe","abc"]
        String s = "abpcplea";
        List<String>list=new ArrayList<>();
        String[]dictionary =new String[]{"ale","apple","monkey","plea"};
        for(int i=0;i<dictionary.length;i++){
            list.add(dictionary[i]);
        }
        System.out.println("abc".compareTo("abe"));
        System.out.println(findLongestWord(s,list));
    }
}
