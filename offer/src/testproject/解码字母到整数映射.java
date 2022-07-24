package testproject;

import org.junit.Test;

public class 解码字母到整数映射 {
    public String freqAlphabets(String s) {
        int len=s.length();
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        for(int i=len-1;i>0;){
            if(sb.charAt(i)=='#'){
                char m1=sb.charAt(i-2);
                char m2=sb.charAt(i-1);
                char count= (char) (((m1-'0')*10+(m2-'0')-10)+'j');
                sb.replace(i-2,i+1, String.valueOf(count));
                i=i-2;
            }else {
                i--;
            }
        }
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)>'0'&&sb.charAt(i)<='9'){
                char count= (char) ((sb.charAt(i)-'1')+'a');
                sb.replace(i,i+1, String.valueOf(count));
            }
        }

        return sb.toString();
    }
    @Test
    public void test(){
        String s = "10#11#12";
        System.out.println(freqAlphabets(s));
    }
}
