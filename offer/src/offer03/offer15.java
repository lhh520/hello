package offer03;

import org.junit.Test;

public class offer15 {
    public int hammingWeight(int n) {
        int sum=0;
        while (n!=0){
           n&=(n-1);
           sum++;
        }
        return sum;
    }
    @Test
    public void test(){
       for(int i=0;i<6;i++){
           System.out.println(1<<i);
       }
    }
}
