package test;

import org.junit.Test;

import java.util.Arrays;

public class 被围绕的区域 {
    int[][]dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }
    }
    public void dfs(char[][]board,int i,int j){
        if(i<=0||i>=board.length-1||j<=0||j>=board[0].length-1||board[i][j]=='X'){
            return;
        }
        board[i][j]='X';
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
