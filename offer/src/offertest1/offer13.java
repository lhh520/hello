package offertest1;

import org.junit.Test;

public class offer13 {
    int ans=0;
    public int movingCount(int m, int n, int k) {
        int[][]board=new int[m][n];
        ans=dfs(board,m,n,k,0,0);
    return ans;
    }
    public int dfs(int[][]board,int m, int n, int k,int i,int j){
         if(i<0||i>=m||j<0||j>=n||!over(i,j,k))
             return 0;
         board[i][j]=1;//防止重复
         return 1+dfs(board,m,n,k,i+1,j)+dfs(board,m,n,k,i,j+1);

    }
    boolean over(int i,int j,int k){
        int sum1=0,sum2=0;
        while (i!=0){
            sum1=sum1+i%10;
            i=i/10;
        }

        while (j!=0){
            sum2=sum2+j%10;
            j=j/10;
        }

        if(sum1+sum2>k)
            return false;
        return true;
    }
    @Test
    public void test(){
        int h=movingCount(2,3,1);
        over(12,51,8);
        System.out.println(h);
    }
}
