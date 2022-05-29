package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 获取单值网格的最小操作数 {
    public int minOperations(int[][] grid, int x) {
        int ret=0;
        int index=0;
        int[]arr=new int[grid.length*grid[0].length];
        //arr
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                arr[index++]=grid[i][j];
            }
        }
        Arrays.sort(arr);
        int mid=arr[arr.length/2];
        for(int v:arr){
            int val=Math.abs(v-mid);
            if(val%x!=0){
                return -1;
            }
            ret=ret+val/x;
        }
        return ret;
    }
    @Test
    public void test(){
        int[][]nums=new int[][]{{2,4},{6,8}};
        System.out.println(minOperations(nums,2));
    }
}
