import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ceshi {
    public  int AmountOfCombination(int[] nums, int target) {
        //请在这里实现算法并返回结果
        int amount = 0;

        List<List<Integer>>ret=new ArrayList<>();
        int num=0;
        if(nums==null||nums.length<4){
            return 0;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j>0&&nums[j]==nums[j-1]){
                    continue;
                }
                if(nums[i]+nums[j+1]+nums[j+2]+nums[j+3]>target){
                    break;
                }
                if(nums[i]+nums[j]+nums[nums.length-2]+nums[nums.length-1]<target){
                    continue;
                }
                int left=j+1,right=nums.length-1;
                while (left<right){
                    int sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        num++;
                        while (left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        left++;
                        while (left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        right--;
                    }else if(sum<target){
                        left++;
                    }else {
                        right--;
                    }

                }
            }
        }
        return num;

    }
    public static char[][] Flick(char[][] matrix) {
        //请在这里实现算法并返回翻转后的结果
        byte[][] result = null;
        int n=matrix.length;
        if(n==0){
            return null;
        }
        int m=matrix[0].length;

        for(int i=0;i<matrix.length;i++){
            dfs(matrix,i,0);
            dfs(matrix,i,m-1);
        }

        for(int i=1;i<m-1;i++){
            dfs(matrix,0,i);
            dfs(matrix,n-1,i);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='A'){
                    matrix[i][j]='O';
                }else if(matrix[i][j]=='O'){
                    matrix[i][j]='X';
                }
            }
        }
        return matrix;
    }
    public static void dfs(char[][]matrix,int x,int y){
        if(x<0||x>=matrix.length||y<0||y>=matrix[0].length){
            return;
        }
        matrix[x][y]='A';
        dfs(matrix,x+1,y);
        dfs(matrix,x-1,y);
        dfs(matrix,x,y+1);
        dfs(matrix,x,y-1);
    }





    @Test
    public void test(){
        //1,0,-1,0,-2,2
        //0
        int[]nums=new int[]{1,0,-1,0,-2,2};
        System.out.println(AmountOfCombination(nums,0));
    }
}
