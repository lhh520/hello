package 代码随想录二刷.数组;

import org.junit.Test;

import java.util.Map;

public class x的平方根 {
    public int mySqrt(int x){
        if(x==0){
            return 0;
        }
        int left=0,right=x,ans=-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(mid*mid<=x){
                ans=mid;
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        System.out.println(mySqrt(3));
    }
}
