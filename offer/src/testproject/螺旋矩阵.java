package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    int[][]dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>list=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[][]flag=new boolean[m][n];
        int index=0;
        int i=0,row=0,col=0;
        while (i<m*n){
            list.add(matrix[row][col]);//加入第一个数据
            System.out.println(matrix[row][col]);
            flag[row][col]=true;
            int newrow=row+dirs[index][0],newcol=col+dirs[index][1];
            if(newrow<0||newrow==m||newcol<0||newcol==n||flag[newrow][newcol]==true){
                index=(index+1)%4;
                //System.out.println(index);
            }
            row=row+dirs[index][0];
            col=col+dirs[index][1];
            i++;
        }
        return list;
    }
    @Test
    public void test(){
        int[][]nums=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer>nn=spiralOrder(nums);
        System.out.println(nn.toString());
    }
}
