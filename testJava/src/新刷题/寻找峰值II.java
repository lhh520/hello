package 新刷题;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class 寻找峰值II {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int[][]matmat=new int[m+2][n+2];
        for(int i=0;i<m+2;i++){
            for(int j=0;j<n+2;j++){
                if(j==0||j==n+1){
                    matmat[i][j]=-1;
                    continue;
                }
                if(i==0||i==m+1){
                    matmat[i][j]=-1;
                    continue;
                }
                matmat[i][j]=mat[i-1][j-1];
            }
            System.out.println(Arrays.toString(matmat[i]));
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                //先判断边界条件
                boolean left=matmat[i][j]>matmat[i][j-1]?true:false;
                boolean right=matmat[i][j]>matmat[i][j+1]?true:false;
                boolean top=matmat[i][j]>matmat[i-1][j]?true:false;
                boolean button=matmat[i][j]>matmat[i+1][j]?true:false;
                if(left&&right&&top&&button){
                    return new int[]{i-1,j-1};
                }
            }
        }
        return new int[]{-1,-1};
    }
    @Test
    public void test(){
        int[][]mat=new int[][]{{1,4},{3,2}};
        System.out.println(Arrays.toString(findPeakGrid(mat)));
    }
}
