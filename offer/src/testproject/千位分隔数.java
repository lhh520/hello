package testproject;

import org.junit.Test;

public class 千位分隔数 {
    public String thousandSeparator(int n) {
        String ss=Integer.toString(n);
        if(ss.length()<=3){
            return ss;
        }
        StringBuilder sb=new StringBuilder();
        String cc=new StringBuilder(ss).reverse().toString();
        int i=0;
        while (i<cc.length()){
            sb.append(cc.charAt(i));
            if(i>0&&i!=cc.length()-1&&(i+1)%3==0){
                sb.append(".");
            }
            i++;
        }
        return sb.reverse().toString();
    }
    @Test
    public void test(){
        System.out.println(thousandSeparator(12345678));
    }
}
