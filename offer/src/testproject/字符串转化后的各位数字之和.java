package testproject;

import org.junit.Test;

public class 字符串转化后的各位数字之和 {
    public int getLucky(String s, int k) {
        int num=0;
        for(int i=0;i<s.length();i++){
            int temp=s.charAt(i)-'a'+1;
            num=num+temp/10;
            num=num+temp%10;
        }
        k--;
        while (k>0){
            k=k-1;
            int temp=num;
            num=0;
            while (temp>0){
                num=num+temp%10;
                temp=temp/10;
            }
        }
        return num;
    }
    @Test
    public void test(){
        String s = "leetcode";
        int k = 2;
        System.out.println(getLucky(s,k));
    }
}
