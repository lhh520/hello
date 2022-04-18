package offer;

import org.junit.Test;

public class offer12 {


    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {   //int k=0;
                if(words[0]==board[i][j])
                {   //System.out.println("i=  "+i+"j=  "+j);
                    return dfs(board,words,i,j,0);

                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, char[] word,int i,int j,int k)
    {
      //  System.out.println("kk");

        if(i>=board.length||j>=board[0].length||i<0||j<0||board[i][j]!=word[k])
        {
            return false;
        }
        if(k==word.length-1)
        {
            return true;
        }

        board[i][j]='\0';


        boolean res= dfs(board,word,i-1,j,k+1)||dfs(board,word,i+1,j,k+1)||dfs(board,word,i,j+1,k+1)||dfs(board,word,i,j-1,k+1);
        board[i][j]=word[k];
        return res;
    }
    @Test
    public void test()
    {   char[][]nn=new char[][]{{'a'},{'a'}};
        String word1="aa";
        //char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean aaa=exist(nn,word1);
        System.out.println(aaa);

    }
}
