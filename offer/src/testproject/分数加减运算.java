package testproject;

import org.junit.Test;

public class 分数加减运算 {
    public String fractionAddition(String expression) {
        long denominator=0,numerator=1;//分子 分母
        int index=0,n=expression.length();
        while (index<n){
            //读取分子
            long denominator1=0,sign=1;
            if(expression.charAt(index)=='-'||expression.charAt(index)=='+'){//开头是符号
                sign=expression.charAt(index)=='-'?-1:1;
                index++;
            }
            while (index<n&&Character.isDigit(expression.charAt(index))){
                denominator1=denominator1*10+expression.charAt(index)-'0';
                index++;
            }
            denominator1=denominator1*sign;
            index++;
            //分母读取
            long numerator1=0;
            while (index<n&&Character.isDigit(expression.charAt(index))){
                numerator1=numerator1*10+expression.charAt(index)-'0';
                index++;
            }
            denominator=denominator*numerator1+denominator1*numerator;
            numerator*=numerator1;
        }
        if(denominator==0){
            return "0/1";//如果分子为0 则返回的是0/1
        }
        long g=gcd(Math.abs(denominator),numerator);//获取最大的公约数
        return Long.toString(denominator/g)+"/"+Long.toString(numerator/g);
    }
    public long gcd(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
    @Test
    public void test(){
        String expression = "-1/2+1/2";
        System.out.println(fractionAddition(expression));
    }
}
