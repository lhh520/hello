package 热题100;

import org.junit.Test;

public class 最长回文串 {
    public String longestPalindrome(String s){
        if(s==""||s.length()<=1){
            return s;
        }
        int startIndex=0;
        int max=0;
        for(int i=0;i<s.length()-1;i++){
            int len1=expand(s,i,i);
            int len2=expand(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>max){
                startIndex=i;
                max=len;
            }
        }
        return s.substring(startIndex,startIndex+max);
    }
    public int expand(String s,int left,int right){
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    @Test
    public void test(){
        String cc="babad";
        System.out.println(longestPalindrome(cc));
    }
}
