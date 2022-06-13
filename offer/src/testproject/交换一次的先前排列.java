package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 交换一次的先前排列 {
    public int[] prevPermOpt1(int[] arr) {
        int len=arr.length;
        int i;
        for(i=len-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                break;
            }
        }
        System.out.println(i);

        if(i<0){
            return arr;//已经是最小的排列
        }
        //
        int max=Integer.MIN_VALUE;
        int pos=-1;
        for(int j=i+1;j<=len-1;j++){
            if(arr[j]>max){
                pos=j;
                max=arr[j];
            }
        }
        System.out.println(max);
        swap(arr,i,pos);
        return arr;
    }
    public void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    @Test
    public void test(){
        int[]arr=new int[]{1,9,4,6,7};
        int[]nn=prevPermOpt1(arr);
        System.out.println(Arrays.toString(nn));
    }
}
