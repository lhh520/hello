package test;

import org.junit.Test;

public class 替换所有的问号 {
    public String modifyString(String s) {
        if(s.equals("?")){
            return "a";
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i>0&&i<s.length()-1&&s.charAt(i)=='?'){//在中间为问
                for(char cc='a';cc<='z';cc++){
                    if(cc!=s.charAt(i-1)&&cc!=s.charAt(i+1)&&cc!= sb.charAt(i-1))
                    {sb.append(cc);
                    break;}
                }
            }else if(i==0&&s.charAt(i)=='?'){
                for(char cc='a';cc<='z';cc++){
                    if(cc!=s.charAt(i+1)){
                        sb.append(cc);
                        break;}
                }
            }else if(i==s.length()-1&&s.charAt(i)=='?'){
                for(char cc='a';cc<='z';cc++){
                    if(cc!=s.charAt(i-1)&&cc!= sb.charAt(i-1)){
                        sb.append(cc);
                        break;}
                }
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        String s = "j?qg??b";
        System.out.println(modifyString(s));
    }
}
