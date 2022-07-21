package 代码随想录二刷.哈希表;

import org.junit.Test;
import 代码随想录二刷.链表.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class 找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        //滑动窗口
        if (s.length() < p.length()) {
            return new ArrayList<Integer>();
        }
        int left=0,right=p.length()-1;
        int[]count=new int[26];
        for(int i=0;i<p.length();i++){
            count[p.charAt(i)-'a']++;
        }
        int[]cur=new int[26];
        for(int i=left;i<=right;i++){
            cur[s.charAt(i)-'a']++;
        }

        System.out.println(1);
        List<Integer>list=new ArrayList<>();
        if(Arrays.equals(cur,count)){
            list.add(left);
        }
        for(int i=1;i<=s.length()-p.length();i++){
            cur[s.charAt(i-1)-'a']--;
            cur[s.charAt(p.length()+i-1)-'a']++;
            if(Arrays.equals(cur,count)){
                list.add(i);
            }
        }
        return list;
    }
    //
    public List<Integer> findAnagrams1(String s, String p) {
        //滑动窗口
        if (s.length() < p.length()) {
            return new ArrayList<Integer>();
        }
        int left=0,right=p.length()-1;
        int[]count=new int[26];
        for(int i=0;i<p.length();i++){
            count[p.charAt(i)-'a']++;
        }
        int[]cur=new int[26];
        for(int i=left;i<=right;i++){
            cur[s.charAt(i)-'a']++;
        }
        System.out.println(1);
        List<Integer>list=new ArrayList<>();
        while (right<s.length()){
            //窗口扩大
            if(Arrays.equals(cur,count)){
                list.add(left);
            }
            right++;
            if(right<s.length())
                cur[s.charAt(right)-'a']++;
            cur[s.charAt(left)-'a']--;
            left++;

        }
        return list;
    }
    @Test
    public void test(){
        String s = "abab", p = "ab";
        List<Integer>list=findAnagrams(s,p);
        System.out.println(list.toString());
    }
}
