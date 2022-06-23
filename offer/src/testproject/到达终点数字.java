package testproject;

import org.junit.Test;

public class 到达终点数字 {
    public int reachNumber(int target) {
    //每次移动的后果就是加上dp[i]+i
        //p+n
        //1 2 3 4
        //p+n=s p-n=target
        //求最小的i 使得i*(i+1)/2>=0 且为偶数
        if(target<0) return -1;
        int res=1;
        while (true){
            int cur=(res*res+res)/2;
            if(cur>target&&(cur-target)%2==0){
                return res;
            }
            res++;
        }
    }
    @Test
    public void test(){

    }
}
