package plan92.test;

public class 单词搜索 {
    public boolean exist(char[][] board, String word){
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(backtrace(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean backtrace(char[][]board,String word,int i,int j,int index){
        if(i<0||i>=board.length||j<0||j>board[0].length||board[i][j]!=word.charAt(index)){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }
        board[i][j]='\0';
        boolean res=backtrace(board,word,i+1,j,index+1)||backtrace(board,word,i,j+1,index+1)||backtrace(board,word,i-1,j,index+1)||backtrace(board,word,i,j-1,index+1);
        board[i][j]=word.charAt(index);
        return res;
    }
}
