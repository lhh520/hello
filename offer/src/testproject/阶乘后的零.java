package testproject;

import org.junit.Test;

public class 阶乘后的零 {
    public int trailingZeroes(int n) {
        int ans=0;
        while (n!=0){
            n/=5;
            ans=ans+n;
        }
        return ans;
    }
    @Test
    public void test(){

    }
}
