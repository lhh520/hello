package test;

import org.junit.Test;

import java.util.Arrays;

public class 被围绕的区域1 {
    int[][]dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public void solve(char[][] board){
        if(board==null||board.length==0){
            return;
        }
        //先将边界相连的转化为#
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean flag=i==0||j==0||i==board.length-1||j==board[0].length-1;
                if(flag){
                    dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][] board,int i,int j){
        if (i < 0 || j < 0 || i >= board.length  || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            // board[i][j] == '#' 说明已经搜索过了.
            return;
        }


        board[i][j]='#';
        for(int[]dir:dirs){
            int dx=dir[0];
            int dy=dir[1];
            dfs(board,i+dx,j+dy);
        }
    }
    @Test
    public void test(){
        char[][]board=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for(char[]tt:board){
            System.out.println(Arrays.toString(tt));
        }
    }
}
