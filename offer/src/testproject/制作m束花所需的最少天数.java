package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 制作m束花所需的最少天数 {
    public int minDays(int[] bloomDay, int m, int k) {
        int left=Arrays.stream(bloomDay).min().getAsInt(),right= Arrays.stream(bloomDay).max().getAsInt();
        if(!isOk(bloomDay,right,m,k)){
            return -1;
        }
        while (left<right){
            int mid=(left+right)/2;
            if(isOk(bloomDay,mid,m,k)){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
    boolean isOk(int[] bloomDay,int mid,int m,int k){
        int sum=0;
        int jj=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                jj++;
                if(jj>=k){
                    jj=0;
                    sum++;
                }
            }else {
                jj=0;
            }
        }
        if(sum>=m){
            return true;
        }else {
            return false;
        }
    }
    @Test
    public void test(){
        int[]bloomDay =new int[]{1,10,3,10,2};

        int m = 3, k = 2;
        boolean jj=isOk(bloomDay,3,m,k);
        System.out.println(jj);
        System.out.println(minDays(bloomDay,m,k));
    }
}
