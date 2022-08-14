package 代码随想录二刷.动态规划;

import java.util.Scanner;

public class 百度02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ss=sc.nextLine();
        //System.out.println(ss);
        String[]sss=ss.split(" ");
        int n=Integer.parseInt(sss[0]);
        int k=Integer.parseInt(sss[1]);
        int[]dp=new int[n+1];
        for(int i=1;i<=k+1;i++){
            dp[i]=1;
        }
        for(int i=k+2;i<=n;i++){
            dp[i]=dp[(i+k)/2]+dp[(i-k)/2];
        }
        System.out.println(dp[n]);
    }



}
