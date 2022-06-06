package testproject;

import org.junit.Test;

public class 出界的路径数 {
    boolean[][]flag;
    int MOD = (int)1e9+7;
    int count=0;//记录所有的路径的数量
    int[][]dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};//四个方向
    int[][][] cache;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        flag=new boolean[m][n];
        int[][]matrix=new int[m][n];
        cache = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }

        return dfs(matrix,startRow,startColumn,maxMove);
    }
    public int dfs(int[][]matrix,int i, int j,int maxMove){
        //表示满足条件的一个走法
        if(maxMove>=0&&(i<0||i>=matrix.length||j<0||j>=matrix[0].length)){
            return 1;
        }
        if(maxMove<0||flag[i][j]){//表示走完步数 或者重复走了路径，则直接返回
            return 0;
        }
        if (cache[i][j][maxMove] != -1) return cache[i][j][maxMove];
        int ans = 0;
        for(int k=0;k<4;k++){
            int dx=dirs[k][0];
            int dy=dirs[k][1];
            ans+=dfs(matrix,i+dx,j+dy,maxMove-1);
            ans %= MOD;
        }
        cache[i][j][maxMove]=ans;
        return ans;
    }
    @Test
    public void test(){
        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        int ans=findPaths(m, n, maxMove, startRow,  startColumn);
        System.out.println(ans);
    }
}
