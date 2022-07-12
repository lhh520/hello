package 代码随想录;

public class 奇数值单元格的数目 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][]dp=new int[m][n];
        for(int[]temp:indices){
            for(int ii=0;ii<n;ii++){
                dp[temp[0]][ii]++;
            }
            for(int ii=0;ii<m;ii++){
                dp[ii][temp[1]]++;
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]%2!=0){
                    count++;
                }
            }
        }
        return count;
    }
}
