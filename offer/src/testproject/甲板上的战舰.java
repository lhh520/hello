package testproject;

public class 甲板上的战舰 {
    int[][]dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    boolean[][]visited;
    int count=0;
    public int countBattleships(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='X'){
                    count++;
                    dfs(board,i,j);
                }

            }
        }
        return count;
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]=='.'){
            return;
        }
        board[i][j]='.';
        for(int k=0;k<4;k++){
            int nx=i+dirs[k][0];
            int ny=j+dirs[k][1];
            dfs(board,nx,ny);
        }
    }

}
