package test;

import org.junit.Test;

public class 仅仅反转字母 {
    public String reverseOnlyLetters(String s) {
        char[]chars=s.toCharArray();
        int i=0,j=s.length()-1;
        while (i<j){
            while (i<j&&!check(chars[i])){
                i++;
//                if(i>=j){
//                    break;
//                }
            }
            while (i<j&&!check(chars[j])){
                j--;
                if(i>=j){
                    break;
                }
            }
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
            i++;
            j--;
        }
        return new String(chars);
    }
    boolean check(char c){
        if((c>='A'&&c<='Z')||(c>='a'&&c<='z')){
            return true;
        }
        return false;
    }
    @Test
    public void test(){
        String s = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s));
    }
}
