package testproject;

import java.util.ArrayDeque;
import java.util.Deque;

public class 地图中的最高点 {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        int[][]ans=new int[m][n];
        Deque<int[]>d=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    d.add(new int[]{i,j});
                }
                ans[i][j]=isWater[i][j]==1?0:-1;//如果是水的话 长素就必须为1
            }
        }
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while (!d.isEmpty()){
            int[]info=d.pollFirst();
            int x=info[0],y=info[1];
            for(int[]di:dirs){
                int nx=x+di[0],ny=y+di[1];
                if(nx<0||nx>=m||ny<0||ny>=n){//表示到了边界
                    continue;
                }
                if(ans[nx][ny]!=-1) continue;//表示已经被处理过了
                ans[nx][ny]=ans[x][y]+1;
                d.addLast(new int[]{nx,ny});
            }
        }
        return ans;
    }
}
