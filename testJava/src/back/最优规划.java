package back;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 最优规划 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String[]ss1=s1.split(" ");
        int n=Integer.parseInt(ss1[0]);
        int m=Integer.parseInt(ss1[1]);
        int k=Integer.parseInt(ss1[2]);
        char[][]color=new char[n][m];
        for(int i=0;i<n;i++){
            String ss=sc.nextLine();
            char[]chars=ss.toCharArray();
            color[i]=chars;
        }
//        for(int i=0;i<n;i++){
//            System.out.println(Arrays.toString(color[i]));
//        }
        int[][]go=new int[n][m];
        for(int i=0;i<n;i++){
            String ss=sc.nextLine();
            String[] ss2=ss.split(" ");
            for(int j=0;j<m;j++){
                go[i][j]=Integer.parseInt(ss2[j]);
            }
        }

        //动态规划
        int[][]dp=new int[n][m];
        dp[0][0]=go[0][0];
        for(int i=1;i<m;i++){
            if(color[0][i]==color[0][i-1]){
                dp[0][i]=dp[0][i-1]+go[0][i];
            }else {
                dp[0][i]=dp[0][i-1]-k;
                if(dp[0][i]<0){
                    dp[0][i]=Integer.MIN_VALUE;
                }else {
                    dp[0][i]+=go[0][i];
                }
            }


        }

        //竖线
        for(int i=1;i<n;i++){
            if(color[i][0]==color[i-1][0]){
                dp[i][0]=dp[i-1][0]+go[i][0];
            }else {
                dp[i][0]=dp[i-1][0]-k;
                if(dp[i][0]<0){
                    dp[i][0]=Integer.MIN_VALUE;
                }else {
                    dp[i][0]+=go[i][0];
                }
            }
            //dp[i][0]=Math.max(dp[i][0],0);

        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                //从上面转化而来 ，上面相等
                int cur1=0,cur2=0;
                if(color[i][j]==color[i-1][j]){
                    cur1=dp[i-1][j]+go[i][j];
                }
                if(color[i][j]!=color[i-1][j]){
                    cur1=dp[i-1][j]-k;
                    if(cur1<0){
                        cur1=Integer.MIN_VALUE;
                    }else {
                        cur1=cur1+go[i][j];
                    }
                }

                //相同
                if(color[i][j]==color[i][j-1]){
                    cur2=dp[i][j-1]+go[i][j];
                }
                if(color[i][j]!=color[i-1][j]){
                    cur2=dp[i][j-1]-k;
                    if(cur2<0){
                        cur2=Integer.MIN_VALUE;
                    }else {
                        cur2+=go[i][j];
                    }
                }

                dp[i][j]=Math.max(cur2,cur1);
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max=Math.max(max,dp[i][j]);
            }
        }
        System.out.println(max);

    }
}
