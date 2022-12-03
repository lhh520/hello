package backtrace;

import java.util.ArrayList;
import java.util.List;

public class testth {
    public static List<Integer>getList(int n){
        if(n==1){
            List<Integer>ret1=new ArrayList<>();
            ret1.add(1);
            return ret1;
        }
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][0]=1;dp[i][i]=1;
        }
        for(int i=2;i<n;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }
        List<Integer>ret=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dp[n-1][i]==0){break;
            }
            ret.add(dp[n-1][i]);
        }
        return ret;
    }
    public static void main(String[] args) {
        List<Integer>list=getList(6);
        System.out.println(list);

    }
}
