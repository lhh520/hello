package offertest1;

import org.junit.Test;

public class offer16 {
    public double myPow(double x, int n) {
        if(Math.abs(x-1)<0.001)
            return 1;
    boolean flag=false;
    if(n<0){
        flag=true;
        n=-n;
    }
    double ans=1.0;
    for(int i=0;i<n;i++){
        ans=ans*x;
    }
    if(flag)
        return 1/ans;
    else
        return  ans;
    }
    public double myPow1(double x, int n){
        boolean flag=false;
        if(n<0){
            x=1/x;
            n=-n;
        }
        double ans=1.0;
        while (n>0){
            if((n&1)==1) ans=ans*x;
            x*=x;
            n=n>>1;
        }

            return ans;
    }
    @Test
    public void test(){
        double x=2.0;
        int n= -2147483648;
        int nn=-n;
        System.out.println(nn);
    }
}
