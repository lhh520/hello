package backtrace;

import org.junit.Test;

import java.util.Arrays;

public class test99888 {
    public int maxDigit (int[] digits) {
        // write code here
        Arrays.sort(digits);
        int ret=0;
        for(int i=digits.length-1;i>=0;i--){
            ret=ret*10+digits[i];
        }
        return ret;
    }
    @Test
    public void test(){
        int[]digits=new int[]{3,4};
        System.out.println(maxDigit(digits));
    }
}
