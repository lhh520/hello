package offer;

import java.util.LinkedList;
import java.util.Queue;

public class offer107 {
    public int[][] updateMatrix(int[][] mat) {
        int [][]nums=new int[mat.length][mat[0].length];
    for(int i=0;i<mat.length;i++)
    {
        for(int j=0;j<mat[0].length;j++)
        {
            if(mat[i][j]==0)
                nums[i][j]=mat[i][j];
            if(mat[i][j]==1)
                nums[i][j]=dfs(mat,i,j);
        }
    }
    return nums;
    }
    static int[][]dirs={{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] updateMatrix1(int[][] mat)
    {
        int m=mat.length,n=mat[0].length;
        int[][]dist=new int[m][n];
        boolean[][]seen=new boolean[m][n];
        Queue<int[]>queue=new LinkedList<int[]>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {   //将所有0的位置添加进入队列
                    queue.add(new int[]{i,j});
                    //并将这些位置置为true
                    seen[i][j]=true;
                }
            }
        }
        //开始进行广度优先遍历
        while (!queue.isEmpty())
        {
            int[] cell=queue.poll();
            int i=cell[0],j=cell[1];
            for(int d=0;d<4;++d)
            {
                int ni=i+dirs[d][0];
                int nj=j+dirs[d][1];
                if(ni>=0&&ni<m&&nj>0&&nj<n&&!seen[ni][nj])
                {
                    dist[ni][nj]=dist[i][j]+1;
                    queue.offer(new int[]{ni,nj});
                    seen[ni][nj]=true;
                }
            }
        }
        return dist;
    }
    public int dfs(int[][] mat,int i,int j)
    {
        if(i<0||i>mat.length||j<0||j>mat[0].length)
            return 0;
        if(mat[i][j]==0)
            return 0;
        return 1+Math.min(Math.min(dfs(mat,i-1,j),dfs(mat,i+1,j)),Math.min(dfs(mat,i,j-1),dfs(mat,i-1,j+1)));
    }
}
