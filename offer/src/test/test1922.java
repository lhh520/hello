package test;

public class test1922 {
    public int countGoodNumbers(long n) {
    long base=20,res=n%2==0?1:5,power=n/2;
    int mod=1000000007;
    while (power>0)
    {
        if(power%2==1)
            res=res*base%mod;
        power/=2;
        base=(base*base)%mod;
    }
    return (int)res;
    }
}
