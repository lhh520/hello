package Shopee;

import java.util.Scanner;

public class ShopeeTanam {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt(),m=sc.nextInt();
            long[][]arr=new long[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            //设计dp数组，dp[i][0] 表示左端点就得到最大值，dp[i][1]表示右端点
            long[][]dp=new long[n][2];
            long cnt=0;
            //初始化
            for(int i=0;i<m;i++){
                cnt+=arr[0][i];
                dp[0][0]=Math.max(cnt,dp[0][0]);
            }
            dp[0][1]=cnt;//到右端点
            for(int i=1;i<n;i++){
                long l=0,r=0;
                for(int j=0,k=m-1;j<m;j++,k--){
                    l+=arr[i][j];
                    r+=arr[i][k];
                    dp[i][0]=Math.max(dp[i][0],l);
                    dp[i][1]=Math.max(dp[i][1],r);
                }
                //上一行从左到右
                dp[i][0]=Math.max(dp[i][0]+dp[i-1][0],dp[i-1][1]+r);
                dp[i][1]=Math.max(dp[i][1]+dp[i-1][1],dp[i-1][0]+l);
            }
            System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));


        }
    }
}
