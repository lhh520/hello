public class test50 {
    public double myPow(double x, int n)
    {
        return n>0?quickMul(x,n):1.0/quickMul(x,-n);

    }
    public double quickMul(double x,int n)
    {
        if(n==0)
            return 1.0;
        double y=quickMul(x,n/2);
        return n%2==0?y*y:y*y*x;
    }
}
