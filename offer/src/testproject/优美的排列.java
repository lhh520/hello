package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 优美的排列 {

    public int countArrangement(int n) {
        return backtrace(1,n,new boolean[n+1]);
    }

    public int backtrace(int i,int n,boolean[]vis) {
        if(i>n) return 1;//说明已经到头了
        int res=0;
        for(int j=1;j<=n;j++){
            if(!vis[j]&&(i%j==0||j%i==0)){
                vis[j]=true;
                res+=backtrace(i+1,n,vis);
                vis[j]=false;
            }
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(countArrangement(15));
    }

}
