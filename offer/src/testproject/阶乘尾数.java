package testproject;

public class 阶乘尾数 {
    public int trailingZeroes(int n) {
        int ret=0;
        while (n!=0){
            n/=5;
            ret+=n;
        }
        return ret;
    }
}
