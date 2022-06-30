package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 和为奇数的子数组数目 {
    public int numOfSubarrays(int[] arr) {
        //前缀和
        final int MODULO = 1000000007;
        int n=arr.length;
        int ret=0;
        int sum=0;
        int odd=0;//奇数
        int enev=1;//偶数
        for(int i=0;i<n;i++){
            sum+=arr[i];
            ret = (ret + (sum % 2 == 0 ? odd : enev)) % MODULO;
            if(sum%2==0){
                enev++;
            }else {
                odd++;
            }
        }

        return ret;
    }
    @Test
    public void test(){
        int[]arr =new int[]{1,3,5};
        System.out.println(numOfSubarrays(arr));
    }
}
