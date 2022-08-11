package stack;

import org.junit.Test;

public class 重新格式化字符串 {
    public String reformat(String s) {
        StringBuilder num=new StringBuilder();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c<='9'&&c>='0') {
                num.append(c);
            }else {
                str.append(c);
            }
        }
        if(Math.abs(num.length()-str.length())>1){
            return "";
        }
        boolean flag= num.length() >=str.length();
        StringBuilder res=new StringBuilder();
        if(flag){
            int i=0,j=0,k=0;
            for( i=0;i<s.length();i++){
                if(i%2==0){
                    res.append(num.charAt(j++));
                }else {
                    res.append(str.charAt(k++));
                }
            }
        }else {
            int i=0,j=0,k=0;
            for( i=0;i<s.length();i++){
            if(i%2==0){
                res.append(str.charAt(j++));
            }else {
                res.append(num.charAt(k++));
            }}
        }
        return res.toString();
    }
    @Test
    public void test(){
        String s = "covid2019";
        System.out.println(reformat(s));
    }
}
