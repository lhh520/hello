package test;

import org.junit.Test;

import java.util.Arrays;

public class 前n个数字二进制中1的个数 {
    public int[] countBits(int n) {
        int[]cc=new int[n+1];
        for(int i=0;i<=n;i++){
            cc[i]=countOnes(i);
        }
        return cc;
    }
    public int countOnes(int n){
        int count=0;
        while (n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
    @Test
    public void test(){
        int n=2;
        int[]bb=countBits(2);
        System.out.println(Arrays.toString(bb));
    }
}
