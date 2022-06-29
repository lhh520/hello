package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 在D天内送达包裹的能力 {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();

        while (left<right){
            int mid=(left+right)/2;
            if(isOk(weights,mid,days)){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
    boolean isOk(int[] weights,int mid,int days){
        int sum=0;
        int cur=1;
        for(int i=0;i<weights.length;i++){
            if(sum+weights[i]>mid){
                sum=0;
                cur++;
            }
            sum+=weights[i];
        }
        if(cur<=days){
            return true;
        }else {
            return false;
        }
    }
    @Test
    public void test(){
        int[]weights =new int[]{1,2,3,1,1};
        int days = 4;
//        isOk(weights,2,4);
//        System.out.println();
        System.out.println(shipWithinDays(weights,days));
    }
}
