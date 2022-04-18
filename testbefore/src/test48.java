import org.junit.Test;

public class test48 {
    public void rotate(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[i][matrix.length - j - 1] = matrix[i][j];
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                matrix[i][j]=temp[i][j];
            }
        }
    }
    @Test
    public void test()
    {
        //matrix = [[1,2,3],[4,5,6],[7,8,9]]
        int[][]matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
