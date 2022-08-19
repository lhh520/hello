package hot100;

public class 旋转图像 {
    public void rotate(int[][] matrix){
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
}
