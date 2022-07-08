package test;

import org.junit.Test;

public class 下一个数 {
    public int exchangeBits(int num) {
        return ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
//        String s = Integer.toBinaryString(num);
//        StringBuilder sb=new StringBuilder(s);
//        for(int i=0;i<sb.length()-1;i+=2){
//            char c1=sb.charAt(i);
//            char c2=sb.charAt(i+1);
//            sb.setCharAt(i,c2);
//            sb.setCharAt(i+1,c1);
//        }
//        System.out.println(Integer.parseInt(sb.toString()));
//        return Integer.parseInt(sb.toString());
    }
    @Test
    public void test(){
        System.out.println(exchangeBits(2));
    }
}
