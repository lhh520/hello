package test;

import org.junit.Test;

public class test504 {
    public String convertToBase7(int num) {
    StringBuilder sb=new StringBuilder();
    boolean flag=false;
    if(num<0){
        flag=true;
        num=-num;
    }
    while (num!=0){
        int temp=num%7;
        sb.append(temp);
        num=num/7;
    }
    if(flag)
        sb.append("-");
    return sb.reverse().toString();
    }
    @Test
    public void test(){
        System.out.println(convertToBase7(-7));
    }
}
