package testproject;

import org.junit.Test;

public class 数字范围按位与 {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==0) return 0;
        while (n>m){
            n&=n-1;
        }
        return n;
    }
    @Test
    public void test(){
        System.out.println(rangeBitwiseAnd(5,7));
    }
}
