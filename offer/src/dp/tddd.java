package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class tddd {
    static int[][]dp=new int[15][15];

    static int N=15;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<=9;i++){
            dp[1][i]=1;
        }
        for(int i=2;i<N;i++){
            for(int j=0;j<=9;j++){
                for(int k=j;k<=9;k++){
                    dp[i][j]+=dp[i-1][k];
                }
            }
        }



        List<Integer> list=new ArrayList<>();
        while (sc.hasNextLine()){
            String read=sc.nextLine();
            if(read==null||read.isEmpty()){
                break;
            }
            String[]ar=read.split(" ");
            int n=Integer.parseInt(ar[0]);
            int m=Integer.parseInt(ar[1]);
            list.add(dfs(m)-dfs(n-1));


        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
//    static int jisuan(int n){
//        int l=0;
//        while (n>0){
//            ss[++l]=n%10;
//            n=n/10;
//        }
//        return dfs(l,0,true);
//    }
    static int dfs(int n){
        if(n<=0){
            return 1;
        }
        List<Integer>list=new ArrayList<>();
        while (n>0){
            list.add(n%10);
            n=n/10;
        }
        int ans=0,last=0;
        for(int i=list.size()-1;i>=0;i--){
            int x=list.get(i);
            for(int j=last;j<x;j++){
                ans+=dp[i+1][j];
            }
            if(x<last){
                break;
            }
            last=x;
            if(i<=0){
                ans++;
            }
        }
        return ans;
    }




}
