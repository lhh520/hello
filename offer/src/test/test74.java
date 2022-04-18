package test;

public class test74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0;
        for (i =m-1; i >0; i--) {
            if(matrix[i][0]<=target)
                break;;
        }
        for(int j=0;j<n;i++)
        {
            if(matrix[i][j]==target)
                return true;
        }
        return false;
    }
}
