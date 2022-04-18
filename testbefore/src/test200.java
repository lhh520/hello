import org.junit.Test;
/*
public class test200 {
    /*int[]dx=new int[]{0,1,0,-1};
    int[]dy=new int[]{-1,0,1,0};
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
       char[][]gridbig=new char[m+2][n+2];
        for(int i=0;i<m+2;i++)
        {
            gridbig[i][0]='0';
            gridbig[i][n+1]='0';
        }
       for(int j=0;j<n+2;j++)
       {
           gridbig[0][j]='0';
           gridbig[m+1][j]='0';
       }
       for(int i=1;i<m+1;i++)
       {
           for(int j=1;j<n+1;j++)
           {
               gridbig[i][j]=grid[i-1][j-1];
           }
       }
       int sum=0;

        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                int count=0;
                //gridbig[i][j]=grid[i-1][j-1];
                for(int k=0;k<4;k++)
                {
                    if(gridbig[i+dx[k]][j+dy[k]]=='1'&&gridbig[i][j]=='1')
                    {   count++;


                    }
                }
                if(count==1)
                {sum++;
                    System.out.println("i:  "+i+"    j   :   "+j);
                }
            }
        }
       return sum;
    }*/
  //  @Test
    /*public void test()
    {
       char[][] grid =new char[][]{{'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };
        int num=numIslands(grid);
        System.out.println(num);


    }*/

public class test200
{
    public int numIslands(char[][] grid)
    {
        int res=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid,i,j);
                    res++;
                }

            }
        }
        return  res;
    }
    public void dfs(char[][]grid,int i,int j)
    {
        if(!Inarea(grid,i,j))
            return;
        if(grid[i][j]!='1')
            return;
        grid[i][j]='2';//将联通的区域的1都破坏掉
        //向四个方向扩散
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);

    }
    //判定是否在区域内
    public Boolean Inarea(char[][]grid,int i,int j)
    {
        return i>=0&&i<grid.length&&j>=0&&j<grid[0].length;
    }
}