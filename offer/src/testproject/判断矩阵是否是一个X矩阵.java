package testproject;

import org.junit.Test;

public class 判断矩阵是否是一个X矩阵 {
    public boolean checkXMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==j&&grid[i][j]==0)){
                    System.out.println(1);
                    return false;
                }else if(i+j==n-1&&grid[i][j]==0){
                    System.out.println(2);
                    return false;
                }else {
                    if(i!=j&&i+j!=n-1&&grid[i][j]!=0){
                        System.out.println("i: "+i+" j "+j);
                        System.out.println(3);
                        return false;
                    }
                }
            }
        }
        return true;
    }
    @Test
    public void test(){
       int[][]nums=new int[][]{{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
        System.out.println(checkXMatrix(nums));
    }
}
