package testproject;

import org.junit.Test;

public class 统计有序矩阵中的负数 {
    public int countNegatives(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]<0){
                    count=count+(n-j);
                    break;
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
        //int[][]grid=new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        int[][]grid=new int[][]{{5,1,0},{-5,-5,-5}};
        System.out.println(countNegatives(grid));
    }
}
