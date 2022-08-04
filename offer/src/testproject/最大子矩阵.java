package testproject;

public class 最大子矩阵 {
    public int[] getMaxMatrix(int[][] matrix) {
        //二维前缀和
        int m=matrix.length,n=matrix[0].length;
        int[][]PreSum=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                PreSum[i][j]=matrix[i-1][j-1]+PreSum[i-1][j]+PreSum[i][j-1]-PreSum[i-1][j-1];
            }
        }
        int gogalMax=Integer.MIN_VALUE;
        int[]ret=new int[4];
        for(int top=0;top<m;top++){
            for(int buttom=top;buttom<m;buttom++){
                int localMax=0,left=0;
                for(int right=0;right<n;right++){
                    localMax = PreSum[buttom + 1][right + 1] + PreSum[top][left] - PreSum[buttom + 1][left] - PreSum[top][right + 1];
                    if(gogalMax<localMax){
                        gogalMax=localMax;
                        ret[0]=top;
                        ret[1]=left;
                        ret[2]=buttom;
                        ret[3]=right;
                    }
                    if(localMax<0){//如果都不满足
                        localMax=0;
                        left=right+1;
                    }

                }
            }
        }
        return ret;
    }
}
