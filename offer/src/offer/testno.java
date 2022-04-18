package offer;

public class testno {
    public int findCircleNum(int[][] isConnected)
    {
        int len=isConnected.length;
        boolean[]visited=new boolean[len];
        int cnt=0;
        for(int i=0;i<len;i++)
        {
            if(!visited[i])
            {
                dfs(i,len,isConnected,visited);
                cnt++;
            }
        }
        return  cnt;
    }
    public void dfs(int i,int len,int[][] isConnected,boolean[]visited)
    {
         visited[i]=true;
         for(int j=0;j<isConnected.length;j++)
         {   if(isConnected[i][j]==1&&!visited[j])
             dfs(j,len,isConnected,visited);
         }
    }
}
