package hot100;

import org.junit.Test;

import java.util.Arrays;

public class 排序 {
    //冒泡排序
    public static int[]bubbleSort(int[]arr){
        for(int i=1;i<arr.length;i++){
            boolean flag=true;
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=false;
                }
            }
//            if(flag){
//                break;
//            }
        }
        return arr;
    }
    //选择排序
    public static int[]selectSort(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            if(min!=i){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
        return arr;
    }
    //插入排序
    public static void QuickSort(int[]arr,int left,int right){
        if(left<right){
            return;
        }
        int left0=left;
        int right0=right;
        int baseNum=arr[left];
        while (left<right){
            while (arr[right]>=baseNum&&left<right){
                right--;
            }
            while (arr[left]<=baseNum&&left<right){
                left++;
            }
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
        int temp=arr[left];
        arr[left]=baseNum;
        arr[left0]=temp;
        QuickSort(arr,left0,left-1);
        QuickSort(arr,right+1,right0);
    }
    @Test
    public void test(){
        int[]arr=new int[]{1,3,2,4};
        int[]ans=selectSort(arr);
        System.out.println(Arrays.toString(ans));
    }
}
