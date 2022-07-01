package testproject;

import org.junit.Test;

public class 质数排列 {
    static final int MOD = 1000000007;
    public int numPrimeArrangements(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(isPrime(i)){
                count++;
            }
        }
        System.out.println(count);
        return (int) ((getIn(count)*getIn(n-count))%MOD);
    }
    public boolean isPrime(int n){
        if(n==1){
            return false;
        }
        for(int i=2;i<Math.sqrt(n+1);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    long getIn(int n){
        long res=1;
        for(int i=1;i<=n;i++){
            res *=i;
            res %=MOD;
        }
        return res;
    }
    public long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= MOD;
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(numPrimeArrangements(100));
    }
}
