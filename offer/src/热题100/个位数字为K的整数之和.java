package 热题100;

import org.junit.Test;

public class 个位数字为K的整数之和 {
    public int minimumNumbers(int num, int k) {
        if(num==0) return 0;
        for(int i=1;i<=10&&num-k*i>=0;i++){
            if((num-k*i)%10==0) return i;
        }
        return -1;
    }
    @Test
    public void test(){
        System.out.println(minimumNumbers(58,9));
    }
}
