package testproject;

import org.junit.Test;

public class 最长回文串 {
    public String longestPalindrome(String s){
        if(s==null||s.length()<1){
            return "";
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1=expandAround(s,i,i);//单个可以
            int len2=expandAround(s,i,i+1);
            int len=Math.max(len1,len2);
            //得到最长字串的长度，开始更新Start和end
            if(len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int expandAround(String s,int left,int right){
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            --left;
            ++right;
        }
        return right-left-1;
    }
    //
    public String longestPalindrome1(String s){
        if(s==null||s.length()<2)
            return s;
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1=extendChar(s,i,i);
            int len2=extendChar(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int extendChar(String s,int left,int right){
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;//返回最长的长度
    }
    @Test
    public void test(){
        String s="babad";
        System.out.println(longestPalindrome1(s));
    }
}
