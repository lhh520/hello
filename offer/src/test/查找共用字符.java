package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 查找共用字符 {
    public List<String> commonChars(String[] words) {
        int[]miniwords=new int[26];
        Arrays.fill(miniwords,Integer.MAX_VALUE);
        for(int i=0;i<words.length;i++){
            int[] wo=new int[26];
            for(int j=0;j<words[i].length();j++){
                wo[words[i].charAt(j)-'a']++;
            }
            for(int k=0;k<26;k++){
                miniwords[k]=Math.min(miniwords[k],wo[k]);
            }
        }
        List<String>list=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(miniwords[i]!=0&&miniwords[i]!=Integer.MAX_VALUE){
                for(int j=0;j<miniwords[i];j++){
                    char c= (char) (i+'a');
                    list.add(String.valueOf(c));
                }
            }

        }
        return list;
    }
    @Test
    public void test(){
        String[]strs=new String[]{"bella","label","roller"};
        List<String>mm=commonChars(strs);
        System.out.println(mm.toString());
    }
}
