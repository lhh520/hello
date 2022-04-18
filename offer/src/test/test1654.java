package test;

import org.junit.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class test1654 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0)
            return false;
        int n=matrix[0].length;

        for(int i=n-1;i>=0;i--){
            if(matrix[0][i]<=target){
                for(int j=0;j<m;j++){
                    if(matrix[j][i]==target)
                        return true;
                }
            }

        }
        return false;
    }
    @Test
    public void test(){
        int[][] matrix=new int[][]{{-5}};
        boolean k=findNumberIn2DArray(matrix,-5);
        System.out.println(k);
    }
}
