package testproject;

public class 转置矩阵 {
    public int[][] transpose(int[][] matrix) {
        if(matrix==null){
            return matrix;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int[][]newmatrix=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                newmatrix[i][j]=matrix[j][i];
            }
        }
        return newmatrix;
    }
}
