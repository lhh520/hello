package 代码随想录;

import org.junit.Test;

import java.util.*;

public class 最大网络秩 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        int[][] graph = new int[n][n];
        for (int[] r : roads) {
            graph[r[0]][r[1]] = 1;
            graph[r[1]][r[0]] = 1;
            degree[r[0]]++;
            degree[r[1]]++;
        }
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                if(graph[i][j] == 1) {
                    ans = Math.max(degree[i] + degree[j] - 1, ans);
                } else {
                    ans = Math.max(degree[i] + degree[j], ans);
                }
            }
        }
        return ans;
    }
    @Test
    public void test(){
        //n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
        int n=4;
        int[][]roads=new int[][]{{0,1},{0,3},{1,2},{1,3}};
        System.out.println(maximalNetworkRank(n,roads));
    }
}
