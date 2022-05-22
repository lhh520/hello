package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public class 确定两个字符串是否接近 {
    public boolean closeStrings(String word1, String word2) {
        int[]nums1=new int[26];
        int[]nums11=new int[26];
        int[]nums2=new int[26];
        int[]nums21=new int[26];
        for(int i=0;i<word1.length();i++){
            nums1[word1.charAt(i)-'a']++;
            if(nums11[word1.charAt(i)-'a']==0)
            nums11[word1.charAt(i)-'a']++;
        }
        for(int i=0;i<word2.length();i++){
            nums2[word2.charAt(i)-'a']++;
            if(nums21[word2.charAt(i)-'a']==0)
                nums21[word2.charAt(i)-'a']++;
        }
        //
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return Arrays.equals(nums1,nums2)&&Arrays.equals(nums11,nums21);
    }
    @Test
    public void test(){
        String s="abcde";
        String s1="aecdb";
        System.out.println(closeStrings(s,s1));
    }
}
