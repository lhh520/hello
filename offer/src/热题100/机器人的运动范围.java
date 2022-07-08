package 热题100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 机器人的运动范围 {
    int[][]dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int movingCount(int m, int n, int k) {
        boolean[][]visited=new boolean[m][n];
        dfs(visited,0,0,k);
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(boolean[][]visited,int i,int j,int k){
        visited[i][j]=true;
        for(int m=0;m<dirs.length;m++){
            int idx=i+dirs[m][0];
            int idy=j+dirs[m][1];
            if(idx>=0&&idx<visited.length&&idy>=0&&idy<visited[0].length&&!visited[idx][idy]&&check(idx,idy,k)){
                dfs(visited,idx,idy,k);
            }
        }
    }
    public boolean check(int i,int j,int k){
        List<Integer>list=new ArrayList<>();
        while (i>0){
            list.add(i%10);
            i=i/10;
        }
        while (j>0){
            list.add(j%10);
            j=j/10;
        }
        int sum=0;
        for(int m=0;m<list.size();m++){
            sum+=list.get(m);
        }
        return sum<=k;
    }
    @Test
    public void test(){
        System.out.println(movingCount(2,3,1));
    }
}
