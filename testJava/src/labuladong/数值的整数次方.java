package labuladong;

public class 数值的整数次方 {
    public double myPow(double x, int n) {
        long N=n;
        return n>0?quickPow(x,N):1.0/quickPow(x,N);
    }
    private double quickPow(double x,long N){
        if(N==0){
            return 1.0;
        }
        double y=quickPow(x,N/2);
        return N%2==0?y*y:y*y*x;
    }
}
