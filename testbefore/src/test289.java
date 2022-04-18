public class test289 {
    public void gameOfLife(int[][] board) {
        int[] neighbors=new int[]{0,-1,1};
        int[][]copyBoard=new int[board.length][board[0].length];
        int rows=board.length;
        int cols=board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copyBoard[row][col] = board[row][col];
            }
        }

     for(int i=0;i<board.length;i++)
     {
         for(int j=0;j<board[0].length;j++)
         {    int nei=0;
              //对每个点进行遍历
              for(int ii=0;ii<3;ii++)
              {
                  for(int jj=0;jj<3;jj++)
                  {
                      if(!(neighbors[ii]==0&&neighbors[jj]==0))
                      {    //左右进行偏移
                           int r=i+neighbors[ii];
                           int c=j+neighbors[jj];
                           if((r<board.length&&r>=0)&&(c<board[0].length&&c>=0)&&Math.abs(board[r][c])==1)
                               nei++;
                      }
                  }
              }
         if(copyBoard[i][j]==1&&(nei<2||nei>3))
             board[i][j]=0;
             if(copyBoard[i][j]==0&&(nei==3))
                 board[i][j]=1;

         }
     }
    }
}
