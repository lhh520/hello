package testproject;

import org.junit.Test;

import java.util.*;

public class 字符频次唯一的最小删除次数 {
    public int minDeletions(String s) {
        int[]nums=new int[26];
        for(int i=0;i<s.length();i++){
            nums[s.charAt(i)-'a']++;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(nums[i]!=0){
                list.add(nums[i]);
            }
        }
        Collections.sort(list);
        int res=0;
        Set<Integer>set=new HashSet<>();
        for(int num:list){
            int cur=num;
            while (set.contains(cur)){
                cur=cur-1;
                res++;
            }
            if(cur>0){
                set.add(cur);
            }
        }
        //list 操作最小次数 使得数值不相等

        return res;
    }
    @Test
    public void test(){
        String s="aaabbbcc";
        System.out.println(minDeletions(s));
    }
}
