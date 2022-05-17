package 热题100;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 腐烂的橘子 {
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = { {-1,0},{1,0},{0,-1},{0,1} };//四个方向移动

        int count = 0; // count 表示新鲜橘子的数量
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});//腐烂的入队
                }
            }
        }
        int round = 0; // round 表示分钟数
        while (count > 0 && !queue.isEmpty()) {//注意条件 count不能少，否则会多计算
            round++;
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                int[] tmp = queue.poll();
                for(int k = 0; k < 4; k++) {
                    int cr = tmp[0] + dir[k][0];
                    int cc = tmp[1] + dir[k][1];
                    if(cr >= 0 && cr < M && cc >= 0 && cc < N && grid[cr][cc] == 1) {
                        grid[cr][cc] = 2;//开始腐烂
                        count--;
                        queue.add(new int[]{cr, cc});//添加新元素
                    }
                }
            }

        }
        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }
    @Test
    public void test(){
        int[][]grid=new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        String c="55";
        int yy=orangesRotting(grid);
        System.out.println(yy);

    }
}
