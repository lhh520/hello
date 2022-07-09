package 热题100;

import org.junit.Test;

public class 兼具大小写的最好英文字母 {
    public String greatestLetter(String s) {
        for(char a='z';a>='a';a--){

            char b= (char) (a-32);

            if(s.contains(String.valueOf(a))&&s.contains(String.valueOf(b))){
                return String.valueOf(b);
            }
        }
        return "";
    }
    @Test
    public void test(){
        String s = "lEeTcOdE";
        System.out.println(greatestLetter(s));
    }
}
