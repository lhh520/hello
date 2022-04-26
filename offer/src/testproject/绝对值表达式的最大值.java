package testproject;

import org.junit.Test;

public class 绝对值表达式的最大值 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int max=0;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1.length;j++){
                max=Math.max(max,Math.abs(arr1[i]-arr1[j])+Math.abs(arr2[i]-arr2[j])+Math.abs(i-j));
            }
        }
        return max;
    }
    @Test
    public void test(){
        int[]arr1=new int[]{1,2,3,4};
        int[]arr2=new int[]{-1,4,5,6};
        System.out.println(maxAbsValExpr(arr1,arr2));
    }
}
