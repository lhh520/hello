package testproject;

import org.junit.Test;

public class 判断字符串的两半是否相似 {
    public boolean halvesAreAlike(String s) {
        if(s.length()%2!=0){
            return false;
        }
        s=s.toLowerCase();
        int count1=0,count2=0;
        for(int i=0;i<s.length()/2;i++){
            //System.out.println(i);
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                count1++;
            }
        }
        for(int i=s.length()/2;i<s.length();i++){
            //System.out.println(i);
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                count2++;
            }
        }
        if(count1==count2){
            return true;
        }else {
            return false;
        }
    }
    @Test
    public void test(){
        String s="book";
        System.out.println(halvesAreAlike(s));
    }
}
