package 新刷题;

public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        int[]nums=new int[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            nums[c-'a']++;
        }
        for(int i=0;i<s.length();i++){
            char tt=t.charAt(i);
            nums[tt-'a']--;
        }
        for(int i=0;i<26;i++){
            if(nums[i]!=0){
                return false;
            }
        }
        return true;
    }
}
