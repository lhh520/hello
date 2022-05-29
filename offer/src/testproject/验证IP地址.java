package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 验证IP地址 {
    public String validIPAddress(String queryIP) {
        String[]strs=queryIP.split("\\.").length>queryIP.split(":").length?queryIP.split("\\.",-1):queryIP.split(":",-1);
        if(strs.length==4){
            for(String s:strs){
                if(s.length()>1&&s.startsWith("0")){
                    return "Neither";
                }
                try {
                    int aa=Integer.parseInt(s);
                    if(aa<0||aa>255){
                        return "Neither";
                    }
                }catch (Exception e){
                    return "Neither";
                }
            }
            return "IPv4";
        }
        if(strs.length==8){
            for(String s:strs){
                //长度
                if(s.length()<1||s.length()>4){
                    return "Neither";
                }
                for(int i=0;i<s.length();i++){
                    char c=s.charAt(i);
                    boolean flag=(c>='0'&&c<='9')||(c>='a'&&c<='z')||(c>='A'&&c<='Z');
                    if(!flag){
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
    @Test
    public void test(){
        String queryIP="2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(validIPAddress(queryIP));
    }
}
