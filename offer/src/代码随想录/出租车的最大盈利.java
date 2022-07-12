package 代码随想录;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 出租车的最大盈利 {
    public long maxTaxiEarnings(int n, int[][] rides){
        long[]dp=new long[n+1];
        //Arrays.sort(rides,(a,b)->(a[1]-b[1]));//将所有的节点按从小到大排序
        Arrays.sort(rides, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int index=0;
        for(int i=1;i<=n;i++){
            //初始化
            dp[i]=dp[i-1];//如果不变化 则为dp[i-1]
            while (index<rides.length&&rides[index][1]<=i){
                dp[i]=Math.max(dp[i],dp[rides[index][0]]+rides[index][1]-rides[index][0]+rides[index][2]);
                index++;
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        int n = 5;
        int[][]rides =new int[][]{{2,5,4},{1,5,1}};
        System.out.println(maxTaxiEarnings(n,rides));
    }
}
