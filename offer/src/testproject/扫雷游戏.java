package testproject;

import org.junit.Test;

public class 扫雷游戏 {
    int[][]dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int i=click[0];
        int j=click[1];
        if(board[i][j]=='M'){
            board[i][j]='X';
        }else {
            dfs(board,i,j);
        }
        return board;
    }
    public void dfs(char[][] board,int i,int j){
        int count=0;
        for(int k=0;k<8;k++){
            int nx=i+dirs[k][0];
            int ny=j+dirs[k][1];
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                continue;
            }
            if(board[nx][ny]=='M'){
                count++;
            }
        }
        if(count==0){
            board[i][j]='B';
            for(int k=0;k<8;k++){
                int nx=i+dirs[k][0];
                int ny=j+dirs[k][1];
                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length||board[nx][ny] != 'E') {
                    continue;
                }
                dfs(board,nx,ny);
            }
        }else {
            board[i][j]= (char) count;
        }

    }
    @Test
    public void test(){
       char[][]nn=new char[][]{{'B','1','E','1','B'},{'B','1','M','1','B'},{'B','1','1','1','B'},{'B','B','B','B','B'}};
       int[]click=new int[]{1,2};
       updateBoard(nn,click);
    }
}
