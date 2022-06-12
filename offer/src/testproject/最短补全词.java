package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 最短补全词 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[]nums=new int[26];
        int eff=0;
        for(int i=0;i<licensePlate.length();i++){
            char c=licensePlate.charAt(i);
            if(c>='a'&&c<='z'){
                nums[c-'a']++;
                eff++;
            }else if(c>='A'&&c<='Z'){
                nums[c-'A']++;
            }
        }
        int[]com=new int[26];
        System.out.println(1);
        int ans=Integer.MAX_VALUE;
        String nn="";
        for(int i=0;i<words.length;i++){
            if(words[i].length()<eff){
                continue;
            }
            int[]temp=nums.clone();
            for(int j=0;j<words[i].length();j++){
                char c=words[i].charAt(j);
                if(c>='a'&&c<='z'&&temp[c-'a']>0){
                    temp[c-'a']--;
                }else if(c>='A'&&c<='Z'&&temp[c-'A']>0){
                    temp[c-'A']--;
                }
            }
            if(Arrays.equals(temp,com)&&ans>words[i].length()){
                nn=words[i];
                ans=nn.length();
            }
        }
        return nn;
    }
    @Test
    public void test(){
        String licensePlate = "1s3 PSt";
        String[]words =new String[]{"step", "steps", "stripe", "stepple"};
        System.out.println(shortestCompletingWord(licensePlate,words));
    }
}
