package testproject;

import org.junit.Test;

public class URL化 {
    public String replaceSpaces(String S, int length) {

        String bb=String.valueOf(S);
        //长度是够用的
        bb=bb.replace(" ","&");
        int i;
        for(i=bb.length()-1;i>=0;i--){
            if(bb.charAt(i)!='&'){
                break;
            }
        }
        bb=bb.substring(0,i+1);
        bb=bb.replaceAll("&","%20");
        StringBuilder sb=new StringBuilder();
        sb.append(bb);
        while (sb.length()<length){
            sb.append("%20");
        }
        System.out.println(bb);
        return sb.toString();
    }
    @Test
    public void test(){
        String ss="ooo";
        String gg=ss;
        System.out.println(ss==gg);
        System.out.println(replaceSpaces("Mr John Smith    ", 13));
    }
}
