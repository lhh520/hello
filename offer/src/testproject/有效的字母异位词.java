package testproject;

import java.util.Arrays;

public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        int[]nums1=new int[26];
        int[]nums2=new int[26];
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            nums1[s.charAt(i)-'a']++;
            nums2[t.charAt(i)-'a']++;
        }
        return Arrays.equals(nums1,nums2);
    }
}
