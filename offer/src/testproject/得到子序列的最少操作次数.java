package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class 得到子序列的最少操作次数 {
    public int minOperations(int[] target, int[] arr) {
        int m=arr.length;
        int n=target.length;
        int[][]dp=new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(arr[i-1]==target[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return n-dp[m][n];
    }
    public int minOperations1(int[] target, int[] arr){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<target.length;i++){
            map.put(target[i],i);
        }
        int n=arr.length;
        int[]nums=new int[n];
        Arrays.fill(nums,-1);
        int index=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                nums[index++]=map.get(arr[i]);
            }
        }
        //求出nums中的最长上升子序列长度，即最终结果
//        int[]dp=new int[n];
//        Arrays.fill(dp,1);
//        for(int i=1;i<n;i++){
//            for(int j=0;j<i;j++){
//                if(nums[j]<nums[i]){
//                    dp[i]=Math.max(dp[i],dp[j]+1);
//                }
//            }
//        }
//        int res=0;
//        for(int i=0;i<n;i++){
//            res=Math.max(res,dp[i]);
//        }
        return target.length-lengthOfLIS(nums);
    }
    private int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }


    @Test
    public void test(){
        //[16,7,20,11,15,13,10,14,6,8]
        //[11,14,15,7,5,5,6,10,11,6]
        int[]target =new int[]{16,7,20,11,15,13,10,14,6,8};
        int[]arr =new int[]{11,14,15,7,5,5,6,10,11,6};
        System.out.println(minOperations1(target,arr));
    }
}
