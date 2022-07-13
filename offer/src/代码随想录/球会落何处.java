package 代码随想录;

import org.junit.Test;

public class 球会落何处 {
    int[][]grid;
    int m,n;
    public int[] findBall(int[][] grid) {
        this.grid=grid;
        m=grid.length;
        n=grid[0].length;
        int[]ret=new int[n];
        for(int i=0;i<n;i++){
            ret[i]=getValue(i);
        }
        return ret;
    }
    public int getValue(int x){
        int r=0,c=x;
        while (r<m){
            int ne=c+grid[r][c];//表示下一个格子的相对坐标
            if(ne<0||ne>n) return -1;//表示左和右越界
            if(grid[r][c]!=grid[r][ne]) return -1;//小球左右摆动
            r++;//运行到了下一行
            c=ne;
        }
        return c;
    }
}
