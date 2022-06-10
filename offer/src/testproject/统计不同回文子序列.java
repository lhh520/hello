package testproject;

import java.util.Arrays;

public class 统计不同回文子序列 {
    int MOD=(int)1e9+7;
    public int countPalindromicSubsequences(String s) {
        char[]cs=s.toCharArray();
        int n=cs.length;
        int[][]f=new int[n][n];
        int[]L=new int[4];
        int[]R=new int[4];
        Arrays.fill(L,-1);
        for(int i=n-1;i>=0;i--){
            L[cs[i]-'a']=i;
            for(int j=i;j<n;j++){
                R[cs[j]-'a']=j;
                for(int k=0;k<4;k++){
                    if(L[k]==-1||R[k]==-1) continue;
                    int l=L[k],r=R[k];
                    if(l==r) f[i][j]=(f[i][j]+2)%MOD;
                    else if(l==r-1) f[i][j]=(f[i][j]+2)%2;
                    else f[i][j]=(f[i][j]+f[l+1][r-1]+2)%MOD;
                }
            }
        }
        return f[0][n-1];
    }
}
