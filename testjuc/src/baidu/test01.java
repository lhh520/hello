package baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        //4 3
        //-1 2 -1 3
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String[]ss1=s1.split(" ");
        int n0=Integer.parseInt(ss1[0]);
        if(n0==0){
            System.out.println(0);
            System.exit(0);
        }
        int n=Integer.parseInt(ss1[1]);
        String s2=sc.nextLine();
        String[]ss2=s2.split(" ");
        int[]nums=new int[ss2.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(ss2[i]);
            sum+=nums[i];
        }

        System.out.println(sum/(1.0* nums.length));
    }

    //
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n+1][k+1];
        int[] prefixSum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
            dp[i][1] = prefixSum[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int t = 1; t < i; t++) {
                    dp[i][j] = Math.min(dp[i][j], dp[t][j-1] + prefixSum[i] - prefixSum[t]);
                }
            }
        }

        return dp[n][k];
    }





}
