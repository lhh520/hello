package labuladong;

import org.junit.Test;

public class 二进制中1的个数 {
    public int hammingWeight(int n) {
        int ret=0;
        for(int i=0;i<32;i++){
            if((n&(1<<i))!=0){
                ret++;
            }
        }
        return ret;
    }
    @Test
    public void test(){
        System.out.println(hammingWeight(11));
    }
}
