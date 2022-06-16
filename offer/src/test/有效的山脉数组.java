package test;

import org.junit.Test;

public class 有效的山脉数组 {
    public boolean validMountainArray(int[] arr) {
        int i=0;
        for(i=0;i<arr.length-1;i++){
            if(arr[i+1]<=arr[i]){
                break;
            }
        }
        System.out.println(i);
        if(i==arr.length-1||i==0){
            return false;
        }
        System.out.println(1);
        for(int j=i;j<arr.length-1;j++){
            if(arr[j+1]>=arr[j]){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        int[]nums=new int[]{4,4,3,2,1};
        System.out.println(validMountainArray(nums));
    }
}
