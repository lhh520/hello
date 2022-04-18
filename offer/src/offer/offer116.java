package offer;

public class offer116 {
    public int findCircleNum(int[][] isConnected)
    {
      int privences= isConnected.length;
      boolean[] visted=new boolean[privences];
      int circles=0;
      for(int i=0;i<privences;i++)
      {
          if(!visted[i])
              dfs(isConnected,visted,privences,i);
          circles++;
      }
      return circles;
    }
    public void dfs(int[][] isConnected,boolean[] visted,int privences,int i)
    {
        for(int j=0;j<privences;j++)
        {
            if(isConnected[i][j]==1&&!visted[j])
            {
                visted[j]=true;
                dfs(isConnected,visted,privences,j);
            }
        }
    }
}
