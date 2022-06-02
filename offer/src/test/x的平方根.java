package test;

import org.junit.Test;

public class x的平方根 {
    public int mySqrt(int x) {
        return (int) Math.pow(x,0.5);
    }
    public int mySqrt1(int x) {
        //return (int) Math.pow(x,0.5);
        int left=1,right=x/2;
        int ans=-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if((long)mid*mid<=x){
                ans=mid;
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        System.out.println(mySqrt1(8));
    }
}
