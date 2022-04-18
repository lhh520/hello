package offertest1;

import org.junit.Test;

import java.util.Arrays;

public class offer15 {
    public int hammingWeight(int n) {
        int res=0;
     while (n!=0){
         n&=(n-1);
         res++;
     }
     return res;
    }
    @Test
    public void test(){
        int n=11;
        System.out.println(hammingWeight(n));
    }
}
