package offer;

public class offer091 {
    public int minCost(int[][] costs) {
    int[][] dp=new int[costs.length][3];
    //第一个房子
    for(int i=0;i<3;i++)
        dp[0][i]=costs[0][i];//第一列，初始值
    for(int i=1;i<costs.length;i++)
    {   //转移方程
        dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+costs[i][0];//当前涂得是红色，则之前的只能涂蓝色，或者绿色
        dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];//当前涂的是蓝色
        dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+costs[i][2];//当前涂的是绿色
    }
    //最后返回最后一行中的最小花费
    return Math.min(dp[costs.length-1][0],Math.min(dp[costs.length-1][1],dp[costs.length-1][2]));
    }
}
