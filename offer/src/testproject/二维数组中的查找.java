package testproject;

public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=n-1;i>0;i++){
            if(matrix[0][i]<target){
                for(int j=0;j<m;i++){
                    if(matrix[j][i]==target){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
