package 代码随想录;

import org.junit.Test;

import java.util.Arrays;

public class 最长湍流子数组 {
    public int maxTurbulenceSize(int[] arr) {
        int len=arr.length;
        int[][]dp=new int[len][2];//i
        dp[0][0]=1;
        dp[0][1]=1;
        int ans=1;
        for(int i=1;i<len;i++){
            dp[i][0]=1;
            dp[i][1]=1;
            if(arr[i]>arr[i-1]){
                dp[i][0]=dp[i-1][1]+1;
            }else if(arr[i]<arr[i-1]) {
                dp[i][1]=dp[i-1][0]+1;
            }
            ans=Math.max(ans,Math.max(dp[i][0],dp[i][1]));
        }
        return ans;
    }
    @Test
    public void test(){
        //arr = [9,4,2,10,7,8,8,1,9]
        int[]arr=new int[]{9,4,2,10,7,8,8,1,9};
        System.out.println(maxTurbulenceSize(arr));
    }
}
