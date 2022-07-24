package 代码随想录二刷.字符串;

import org.junit.Test;

public class 反转字符串2 {
    char[]cc;
    public String reverseStr(String s, int k) {
        cc=s.toCharArray();
        for(int i=0;i<cc.length;i=i+2*k){
            if(i+k<=s.length()){//可以有数字进行反转
                swap(i,i+k-1);
                continue;
            }
            swap(i,s.length()-1);
        }
        return new String(cc);
    }
    public void swap(int i,int j){
        while (i<j){
            char temp=cc[i];
            cc[i]=cc[j];
            cc[j]=temp;
            i++;
            j--;
        }
    }
    @Test
    public void test(){
        String s = "a";int k = 2;
        System.out.println(reverseStr(s,k));

    }
}
