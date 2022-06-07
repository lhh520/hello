package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 复数乘法 {
    public String complexNumberMultiply(String num1, String num2) {
        int[]n1=preProcess(num1);
        int[]n2=preProcess(num2);
        int m1=n1[0]*n2[0]-n1[1]*n2[1];
        int m2=n1[1]*n2[0]+n1[0]*n2[1];
        return ""+m1+"+"+m2+"i";
    }
    public int[]preProcess(String num){
        String[]strs=num.split("\\+");
        System.out.println(Arrays.toString(strs));
        int n1=Integer.parseInt(strs[0]);
        int n2=Integer.parseInt(strs[1].substring(0,strs[1].indexOf('i')));
        return new int[]{n1,n2};
    }
    @Test
    public void test(){
        String num1 = "1+1i", num2 = "1+1i";
        System.out.println(complexNumberMultiply(num1,num2));
    }
}
