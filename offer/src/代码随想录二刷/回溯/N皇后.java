package 代码随想录二刷.回溯;
import java.util.*;
public class N皇后 {
    List<List<String>>res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n){
        char[][]chessboard=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(chessboard[i],'.');
        }
        backtrace(n,0,chessboard);
        return res;
    }
    public void backtrace(int n,int row,char[][]chessboard){
        if(row==n){
            res.add(Array2List(chessboard));
        }
        for(int col=0;col<n;col++){
            if(isValid(row,col,n,chessboard)){
                chessboard[row][col]='Q';
                backtrace(n,row+1,chessboard);
                chessboard[row][col]='.';
            }
        }
    }
    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public boolean isValid(int row,int col,int n,char[][]chessboard){
        for(int i=0;i<row;i++){//检查列
            if(chessboard[i][col]=='Q'){
                return false;
            }
        }
        //检查45度对角线
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(chessboard[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0&&j<=n-1;i--,j++){
            if(chessboard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}
