package HW;

import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int cnt= jump(nums,k);
        System.out.println(cnt);
    }
    public static int jump(int[]nums,int k){
        int[]dp=new int[nums.length];
        Arrays.fill(dp,100001);
        int len=nums.length;
        for(int i=len-1;i>=0;i--){
            if(nums[i]+i>=len)
                dp[i]=1;
        }
        for(int i=len-1;i>=0;i--){
            if(dp[i]!=1){
                int canmove=nums[i];
                for(int j=canmove;j>0;j--){
                    dp[i]=Math.min(dp[i],dp[i+j]+1);
                }
            }
        }
        return dp[0]>=100001?-1:dp[0];

    }
}
