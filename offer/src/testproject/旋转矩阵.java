package testproject;

public class 旋转矩阵 {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][]ret=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                ret[j][n - i - 1] = matrix[i][j];
            }
        }
        matrix=ret;
    }
}
