package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 重新格式化字符串 {
    public String reformat(String s) {
        if(s.length()==0){
            return "";
        }
        char[] cc=s.toCharArray();
        int counter=0;

        for(int i=0;i<cc.length;i++){
            if(cc[i]>='0'&&cc[i]<='9'){
                counter++;
            }
        }
        //System.out.println(counter);
        int count1=s.length()-counter;
        if(counter-count1<-1||counter-count1>1){
            return "";
        }
        int ii=0,jj=1,k=0;
        if(counter>count1){
            ii=0;jj=1;
        }else {
            ii=1;jj=0;
        }
        char[]chars=new char[s.length()];

        while (k<cc.length){
            if(cc[k]>='0'&&cc[k]<='9'&&ii<s.length()){
                chars[ii]=cc[k];
                ii=ii+2;
            }else
            {   if(jj<s.length())
            {chars[jj]=cc[k];
                jj+=2;}
            }
            k++;
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<chars.length;i++){
            //System.out.println(chars[i]);
            sb.append(chars[i]);
        }
        return sb.toString();
    }
    @Test
    public void test(){
        String s = "covid2019";
        System.out.println(reformat(s));
    }
}
