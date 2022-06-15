package test;

public class 三维形体投影面积 {
    //[[1,2],[3,4]]
    public int projectionArea(int[][] grid) {
        int ans1=0,ans2=0,ans3=0;
        for(int i=0;i<grid.length;i++){
            int a=0,b=0;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0) ans1++;
                if(grid[i][j]>0) a=Math.max(a,grid[i][j]);
                if(grid[j][i]>0) b=Math.max(b,grid[j][i]);
            }
            ans2+=a;
            ans3+=b;
        }
        return ans1+ans2+ans3;
    }
}
