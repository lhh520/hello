package dp;

import java.util.*;

public class hgdds {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]dp=new int[n];
        dp[0]=1;
        int mod=1000000000+7;
        for(int i=1;i<n;i++){
            if((i-1)%2==0){
                 dp[i]=(dp[i-1]%mod+1)%mod;
            }else {
                dp[i]=(dp[i-1]%mod*2)%mod;
            }
        }
        System.out.println(dp[n-1]);
    }
}
