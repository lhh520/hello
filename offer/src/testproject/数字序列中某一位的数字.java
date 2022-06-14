package testproject;

import org.junit.Test;

public class 数字序列中某一位的数字 {
    public int findNthDigit(int n) {
        int digit=1;
        int start=1;
        int count=9;
        //获取n所在的位数 以及所在的数字
        while (n>count){
            n-=count;
            digit++;
            start*=10;
            count=digit*start*9;
        }
        System.out.println(n);
        System.out.println(start);
        long num=start+(n-1)/digit;//已经求出来
        System.out.println(num);
        return Long.toString(num).charAt((n-1)%digit)-'0';
    }
    @Test
    public void test(){
        System.out.println(findNthDigit(100));
    }
}
