package testproject;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class 长度为3的不同回文子序列 {
    public int countPalindromicSubsequence(String s) {
        int res=0;
        for(char c='a';c<='z';c++){
            int left=0;
            int right=s.length()-1;
            while(left<s.length()&&s.charAt(left)!=c){
                left++;
            }
            while(right>0&&s.charAt(right)!=c){
                right--;
            }
            if(right-left<2){
                continue;
            }else {
                Set<Character>set=new HashSet<>();
                for(int ii=left+1;ii<right;ii++){
                    set.add(s.charAt(ii));
                }
                res=res+set.size();
            }
        }
        return res;
    }
    @Test
    public void test(){
        String s = "aabca";
        System.out.println(countPalindromicSubsequence(s));
    }
}
