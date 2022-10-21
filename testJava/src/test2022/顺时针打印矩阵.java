package test2022;

public class 顺时针打印矩阵 {
    //
    int[][]dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return new int[]{};
        }
        int[]nums=new int[matrix.length*matrix[0].length];
        int m=matrix.length,n=matrix[0].length;
        boolean[][]flag=new boolean[m][n];
        int index=0;
        int row=0,col=0;
        for(int i=0;i<m*n;i++){
            nums[i]=matrix[row][col];
            flag[row][col]=true;
            int nexRow=row+dirs[index][0];
            int newCol=col+dirs[index][1];
            if(nexRow<0||nexRow>=m||newCol<0||newCol>=n||flag[nexRow][newCol]){
                 index=(index+1)%4;
            }
            row+=dirs[index][0];
            col+=dirs[index][1];
        }
        return nums;
    }
}
