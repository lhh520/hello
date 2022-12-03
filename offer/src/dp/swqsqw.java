package dp;

import java.util.*;

public class swqsqw {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        if(s1.length()==0){
            System.out.println(0);
            return;
        }
        String[]s11=s1.split(" ");
        int n=Integer.parseInt(s11[0]);
        int m=Integer.parseInt(s11[1]);
        int k=Integer.parseInt(s11[2]);
        if(n==0||m==0||n>100||m>100){
            System.out.println(0);
            return;
        }
        int[][]dp=new int[n][m];
        for(int i=0;i<k;i++){
            String s2=sc.nextLine();
            String[]s12=s1.split(" ");
            int x=Integer.parseInt(s12[0]);
            int y=Integer.parseInt(s12[1]);
            dp[x-1][y-1]=1;
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]==1){
                    int cur=0;
                    for(int kk=0;kk<m;kk++){
                        cur++;
                    }
                    for(int kk=0;kk<n;kk++){
                        cur++;
                    }
                    cnt=Math.max(cur-1,cnt);
                }
            }
        }
        System.out.println(cnt);
    }
}
