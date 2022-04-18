package offertest1;

public class offer12 {
    boolean[][]flag;
    public boolean exist(char[][] board, String word) {
    char[]words=word.toCharArray();
    flag=new boolean[board.length][board[0].length];
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){//每一个都进行搜索，任何和当前一样的都应该继续搜索
            if(dfs(board,words,i,j,0))
                return true;
        }
    }
    return false;
    }
    public boolean  dfs(char[][] board,char[]words,int i,int j,int index){
        if(i>=board.length||i<0||j>=board[0].length||j<0||board[i][j] != words[index]||flag[i][j])//越界，则直接退出或者不相等
            return false;
        if(index==words.length-1) return true;//遍历完成，输出true
        //向上下左右四个方向遍，先将当前的元素设置为空
        flag[i][j]=true;
        //board[i][j] = '\0';
        boolean res=dfs(board,words,i+1,j,index+1)||dfs(board,words,i-1,j,index+1)||
                dfs(board,words,i,j+1,index+1)||dfs(board,words,i,j-1,index+1);
        //board[i][j]=words[index];//防止重复访问
        return res;
    }
}
