package 热题100;

import org.junit.Test;

public class 旋转图像 {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][]temp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                temp[j][m-i-1]=matrix[i][j];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=temp[i][j];
            }
        }
    }
    @Test
    public void test(){
        int[][]matrix =new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
