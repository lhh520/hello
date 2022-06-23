package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 匹配子序列的单词数 {
    List<String>list=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public int numMatchingSubseq(String s, String[] words) {
        char[]chars=s.toCharArray();
        backtrace(chars,0);
        System.out.println(list.toString());
        int res=0;
        for(int j=0;j< words.length;j++){
            if(list.contains(words[j])){
                res++;
            }
        }
        return res;
    }
    public void backtrace(char[]chars,int index){
        list.add(sb.toString());
        if(index>=chars.length){
            return;
        }

        for(int i=index;i<chars.length;i++){
            sb.append(chars[i]);
            backtrace(chars,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public int numMatchingSubseq1(String s, String[] words){
        List<List<String>>arr=new ArrayList<>();
        int res=0;
        for(int i=0;i<26;i++){
            arr.add(new ArrayList<>());
        }
        for(String w:words){
            arr.get(w.charAt(0)-'a').add(w);
        }
        for(int i=0;i<s.length();i++){
            List<String>temp=arr.get(s.charAt(i)-'a');
            int size=temp.size();
            for(int j=size-1;j>=0;j--){
                String word=temp.get(j);
                if(word.length()==1){
                    res++;
                }else {
                    String w=word.substring(1,word.length());
                    arr.get(w.charAt(0)-'a').add(w);
                }
                temp.remove(j);
            }
        }
        return res;
    }



    @Test
    public void test(){
        String s = "dsahjpjauf";
        String[]words =new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        System.out.println(numMatchingSubseq(s,words));
    }
}
