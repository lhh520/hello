package test;

import org.junit.Test;

public class 可以输入的最大单词数 {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[]strs=text.split(" ");
        int count=0;
        for(int i=0;i<strs.length;i++){
            boolean flag=false;
            for(int j=0;j<brokenLetters.length();j++){
                if(strs[i].contains(String.valueOf(brokenLetters.charAt(j)))){
                    flag=true;
                    break;
                }
            }
            if(!flag)
            count++;
        }
        return count;
    }
    @Test
    public void test(){
        String text = "hello world", brokenLetters = "ad";
        System.out.println(canBeTypedWords(text,brokenLetters));
    }
}
