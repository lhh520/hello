package testproject;

public class 矩阵对角线元素的和 {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int ret=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j||i+j==n-1){
                    ret+=mat[i][j];
                }
            }
        }

        return n%2==0?ret:ret-mat[n/2][n/2];
    }
}
