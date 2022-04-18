package nums;

import org.junit.Test;

import java.util.Arrays;

public class test59 {
    public int[][] generateMatrix(int n) {
        int[][]dricts=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[][]nums=new int[n][n];
        int curNum=1;
        int row=0,col=0;
        int index=0;
        while(curNum<=n*n){
            nums[row][col]=curNum;
            curNum++;
            int nextRow=row+dricts[index][0];
            int nextCol=col+dricts[index][1];
            if(nextRow<0||nextRow>=n||nextCol<0||nextCol>=n||nums[nextRow][nextCol]!=0){
                index=(index+1)%4;//说明需要更新了
            }
            row=row+dricts[index][0];
            col=col+dricts[index][1];
        }
        return nums;
    }
    @Test
    public void test(){
        int[][]nums=generateMatrix(3);
        for(int i=0;i<nums.length;i++){
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}
