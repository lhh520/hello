package 新刷题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 完美字符串 {
    List<String> list=new ArrayList<>();
    StringBuffer sb=new StringBuffer();
    Set<String>set=new HashSet<>();
    public int countCompleteSubstrings(String word, int k) {
        for(int i=0;i<word.length();i++){
            for(int j=i;j<word.length();j++){
                String str=word.substring(i,j+1);
                if(isPerfact(str,k)&&set.add(str)){
                    list.add(str);
                }

            }
        }



        return list.size();
    }
    public void backtrace(String word,int index,int k){
        if(index==word.length()){
            if(isPerfact(sb.toString(),k)){
                list.add(sb.toString());
            }
            return;
        }
        for(int i=index;i<word.length();i++){
            sb.append(word.charAt(i));
            backtrace(word,i+1,k);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public boolean isPerfact(String sb,int k){
        int[]fr=new int[26];
        for(int i=0;i<sb.length()-1;i++){
            fr[sb.charAt(i)-97]++;
            if(sb.charAt(i+1)-sb.charAt(i)>2){
                return false;
            }
        }
        fr[sb.charAt(sb.length()-1)-97]++;
        for(int i=0;i<fr.length;i++){
            if(fr[i]!=k&&fr[i]!=0){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println('a'-0);
        int tt=countCompleteSubstrings("igigee",2);
        System.out.println(isPerfact("igigee",2));
        System.out.println(tt);
    }
}
