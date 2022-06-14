package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 对角线遍历 {
    int[][]dirs=new int[][]{{-1,1},{1,-1}};
    public int[] findDiagonalOrder(int[][] mat) {
        int[]ans=new int[mat.length*mat[0].length];
        int m=mat.length;
        int n=mat[0].length;
        for(int i=0,j=0,x=0,y=0;i<ans.length;i++){
            ans[i]=mat[x][y];
            int nx=x+dirs[j][0],ny=y+dirs[j][1];
            if(nx<0||nx== mat.length){//到了左右边界，
                if(y<mat.length-1){
                    y++;
                }else {
                    x++;
                }
                j=1-j;
            }
            else if(ny<0||ny==mat[0].length){//超过左右边界，优先往下拐
                if(x<mat.length-1){
                    x++;
                }else {
                    y++;
                }
                j=1-j;
            }
            else {
                x=nx;
                y=ny;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[][]xy=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[]uu=findDiagonalOrder(xy);
        System.out.println(Arrays.toString(uu));
    }
}
