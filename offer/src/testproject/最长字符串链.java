package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 最长字符串链 {
    public int longestStrChain(String[] words) {
        //进行排序
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        int[]dp=new int[words.length];
        Arrays.fill(dp,1);
        int n=words.length;
        int res=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(machStr(words[j],words[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res=Math.max(res,dp[i]);
        }

        return res;
    }
    public boolean machStr(String s1, String s2){
        if(s1.length()!=s2.length()-1){
            return false;
        }
        int i=0;
        for(int j=0;j<s2.length()&&i<s1.length();j++){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
            }
        }
        return i==s1.length();
    }
    @Test
    public void test(){
        String[]nums=new String[]{"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(nums));;
    }
}
