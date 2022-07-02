package testproject;

import java.util.Map;

public class 元素和小于等于阈值的正方形的最大边长 {
    public int maxSideLength(int[][] mat, int threshold) {
        int row=mat.length;
        int col=mat[0].length;
        int[][]presum=new int[row+1][col+1];
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                presum[i][j]=presum[i-1][j]+presum[i][j-1]-presum[i-1][j-1]+presum[i][j];
            }
        }
        int left=0,right=Math.min(row,col),mid=0,res=0;
        while (left<right){
            mid=(left+right+1)>>1;
            boolean flag=false;
            for (int i = 1; i + mid <= row + 1; ++i) {
                for (int j = 1; j + mid <= col + 1; ++j) {
                    int temp = presum[i + mid - 1][j + mid - 1] - presum[i + mid - 1][j - 1] - presum[i - 1][j + mid - 1] + presum[i - 1][j - 1];
                    if (temp <= threshold) {
                        flag = true;
                    }
                }
            }
            if (flag) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
