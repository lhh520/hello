package offer03;

public class offer12 {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                boolean ans=dfs(board,word,0,i,j);
                if(ans)
                    return ans;

            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word,int index,int i,int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(index)){
            return false;
        }
        if(index==word.length()-1)
            return true;
        board[i][j]='\0';
        //回溯方法
        boolean res=dfs(board,word,index+1,i,j+1)||dfs(board,word,index+1,i,j-1)||dfs(board,word,index+1,i-1,j)||dfs(board,word,index+1,i+1,j);
        board[i][j]=word.charAt(index);
        return res;
    }
}
