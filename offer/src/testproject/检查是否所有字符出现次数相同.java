package testproject;

import java.util.HashSet;
import java.util.Set;

public class 检查是否所有字符出现次数相同 {
    public boolean areOccurrencesEqual(String s) {
        int[]nums=new int[26];
        for(int i=0;i<s.length();i++){
            nums[s.charAt(i)-'a']++;
        }
        int num=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0&&num==0){
                num=nums[i];
            }else if(nums[i]!=0&&num!=0&&num!=nums[i]){
                return false;
            }
        }
        return true;
    }
}
