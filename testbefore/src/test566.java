import org.junit.Test;

import java.util.Arrays;

public class test566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c!=mat.length*mat[0].length)
            return mat;
        int[]nums=new int[mat.length*mat[0].length];
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                nums[i* mat[0].length+j]=mat[i][j];
            }
        }
        //System.out.println(Arrays.toString(nums));
        int[][]newmat=new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                newmat[i][j]=nums[i*c+j];
            }
        }
        System.out.println("hello");
        return newmat;
    }
    @Test
    public void test()
    {
        int[][]mat=new int[][]{{1},{2},{3},{4}};
        int[][]mm=matrixReshape(mat,4,1);
        System.out.println(Arrays.toString(mm));
    }
}
