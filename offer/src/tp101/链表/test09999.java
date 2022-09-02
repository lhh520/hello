package tp101.链表;

import org.junit.Test;

import java.util.Arrays;

public class test09999 {
    public int bbbb(int[][]matrix,int k){
        int m=matrix.length,n=matrix[0].length;
        int[][]PreSum=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                PreSum[i][j]=matrix[i-1][j-1]+PreSum[i-1][j]+PreSum[i][j-1]-PreSum[i-1][j-1];
            }
        }
        int ret=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i>=k&&j>=k){
                    int localMax = PreSum[i][j] + PreSum[i-k][j-k] - PreSum[i-k][j] - PreSum[i][j-k];
                    ret+=localMax;
                }
            }
        }


        return ret;

    }
    public int gcd(int a,int b){
        while(b!=0) {
            int tmp=a;
            a=b;
            b=tmp%b;
        }
        return a;
    }
    @Test
    public void test(){
        int n=3,m=3;
        int[][]matrix=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                    matrix[i][j]=gcd(i+1,j+1);

            }
        }

        int yy=bbbb(matrix,2);
        System.out.println(yy);
    }
}
