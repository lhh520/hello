package testproject;

import org.junit.Test;

public class 分割平衡字符串 {
    public int balancedStringSplit(String s) {
        //滑动窗口
        int left=0,right=0;
        char[] chars=s.toCharArray();
        int num=0;
        while (right<s.length()){
            if(!check(chars,left,right)){
                right++;
                continue;
            }
            num++;
            left=right+1;
            right=right+1;
        }
        return num;
    }
    public boolean check(char[]chars,int i,int j){
        if(i==j){
            return false;
        }
        int num1=0;
        int num2=0;
        for(int k=i;k<=j;k++){
            if(chars[k]=='R'){
                num1++;
            }else {
                num2++;
            }
        }
        if(num1==num2){
            return true;
        }
        return false;
    }
    @Test
    public void test(){
        String s="RLRRLLRLRL";
        System.out.println(balancedStringSplit(s));
    }
}
