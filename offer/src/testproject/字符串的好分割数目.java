package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 字符串的好分割数目 {
    public int numSplits(String s) {
        int[]nums1=new int[s.length()+1];
        nums1[0]=0;
        int[]nums2=new int[s.length()+1];
        nums2[nums2.length-1]=0;
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
            nums1[i+1]=set.size();
        }
        set.clear();
        System.out.println(Arrays.toString(nums1));
        for(int i=s.length()-1;i>=0;i--){
            set.add(s.charAt(i));
            nums2[i]=set.size();
        }
        int count=0;
        for(int i=0;i<nums2.length;i++){
            if(nums1[i]==nums2[i]){
                count++;
            }
        }

        return count;
    }
    @Test
    public void test(){
        System.out.println(numSplits("aacaba"));
    }
}
