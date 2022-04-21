package offer03;

import org.junit.Test;

import java.util.Arrays;

public class offer16 {
    public double myPow(double x, int n) {
        long N=n;
        return N>=0?quickpow(x,N):1.0/quickpow(x,N);
    }
    public double quickpow(double x,long N){
        if(N==0)
            return 1.0;//任何数的0次方都等于1
        double y=quickpow(x,N/2);
        return N%2==0?y*y:y*y*x;
    }
    public int[] printNumbers(int n) {
        int nm=(int)Math.pow(10,n)-1;
        int[]nums=new int[nm];
        for(int i=0;i<nm;i++){
            nums[i]=i+1;
        }
        return nums;
    }
    @Test
    public void test(){
        int[] nn=printNumbers(1);
        System.out.println(Arrays.toString(nn));
    }
}
