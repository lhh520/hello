package test;

public class test172 {
    public int trailingZeroes(int n) {
        int sum=0;
    while (n>5){
        sum=sum+1;
        n=n/5;
    }
    return sum;
    }
}
