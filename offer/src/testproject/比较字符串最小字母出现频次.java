package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 比较字符串最小字母出现频次 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[]qury=count(queries);
        int[]word=count(words);
        System.out.println(Arrays.toString(qury));
        System.out.println(Arrays.toString(word));
        int[]ans=new int[qury.length];
        Arrays.sort(word);
        for(int i=0;i<qury.length;i++){
            for(int j=0;j<word.length;j++){
                if(qury[i]<word[j]){
                    ans[i]=word.length-j;
                    break;
                }
            }
        }
        return ans;
    }
    public int[]count(String[] words){
        int len=words.length;
        int[]cc=new int[len];
        for(int i=0;i<len;i++){
            char c;
            for(c='a';c<='z';c++){
                if(words[i].contains(String.valueOf(c))){
                    break;
                }

            }
            for(int j=0;j<words[i].length();j++){
                if(words[i].charAt(j)==c){
                    cc[i]++;
                }
            }
        }
        return cc;
    }
    @Test
    public void test(){
        String[]queries =new String[]{"bbb","cc"};
        String[]words =new String[]{"a","aa","aaa","aaaa"};
        int[]aa=numSmallerByFrequency(queries,words);
        System.out.println(Arrays.toString(aa));
    }
}
