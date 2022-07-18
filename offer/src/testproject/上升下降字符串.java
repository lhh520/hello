package testproject;

import org.junit.Test;

public class 上升下降字符串 {
    public String sortString(String s) {
        int[]counts=new int[26];
        for(int i=0;i<s.length();i++){//桶排序
            counts[s.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        while (sb.length()<s.length()){
            for(int i=0;i<26;i++){//正向搜索的是最小的值
                if(counts[i]>0){
                    sb.append((char)(i+'a'));
                    counts[i]--;
                }
            }
            //开始反向搜索
            for(int i=25;i>=0;i--){
                if(counts[i]>0){
                    sb.append((char)(i+'a'));
                    counts[i]--;
                }
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        String s = "aaaabbbbcccc";
        System.out.println(sortString(s));
    }
}
