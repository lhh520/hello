package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最长的环 {
    int[][]map;
    int[]visited;
    List<Integer>path=new ArrayList<>();
    int[]path1=new int[100000];
    int v;
    int m = 0;
    int max = 0;
    public int longestCycle(int[] edges) {
        int len=edges.length;
        map=new int[len][len];
        visited=new int[len];
        v=len;
        for(int i=0;i<len;i++){
            Arrays.fill(map[i],0);
        }
        for(int i=0;i<edges.length;i++){
            if(edges[i]!=-1)
            map[i][edges[i]]++;
        }
        for (int i = 0; i < len; i++) {
            if (visited[i] != -1)
                dfs(i);
        }
        return max==0?-1:max;
    }
    public void dfs(int k) {
        visited[k] = 1;
        //path.set(m++,k);
        path1[m++]=k;
        for (int i = 0; i < v; i++) {
            if (map[k][i] == 1) {
                if (visited[i] == 0) {
                    dfs(i);
                }
                if (visited[i] == 1) {
                    int cnt = 0;
                    for (int j = m - 1;; j--) {
                        cnt++;
                        if (path1[j]== i) {
                            break;
                        }
                    }
                    if (cnt > max) {
                        max = cnt;
                    }
                }
            }
        }
        visited[k] = -1;
        m--;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,0,4,5,6,3,8,9,7};
        System.out.println(longestCycle(nums));
    }
}
