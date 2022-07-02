package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 二维网格迁移 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        for(int ii=0;ii<k;ii++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = n - 1; j >= 1; j--) {
                    if (j == n - 1) {
                        list.add(grid[i][j]);
                    }
                    grid[i][j] = grid[i][j - 1];
                }
            }
            System.out.println(1);
            //开始处理第一列
            for (int i = 1; i < m; i++) {
                grid[i][0] = list.get(i - 1);
            }
            grid[0][0] = list.get(n - 1);
        }
        List<List<Integer>>lists=new ArrayList<>();
        for(int i=0;i<m;i++){
            List<Integer>cur=new ArrayList<>();
            for(int j=0;j<n;j++){
                cur.add(grid[i][j]);
            }
            lists.add(new ArrayList<>(cur));
        }
        return lists;
    }
    @Test
    public void test(){
        int[][]grid=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        shiftGrid(grid,1);
    }
}
