package back;

import org.junit.Test;

import java.util.*;
public class 快排 {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    //快排输入参数：
    public void quickSort(int[]arr,int left,int right){
        if(left>right){//快排已经到了结束点了
            return;
        }
        int left0=left;
        int right0=right;
        int baseNum=arr[left];
        while (left!=right){

            while(left<right&&arr[right]>=baseNum){
                right--;
            }
            while (left<right&&arr[left]<=baseNum){
                left++;
            }
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
        int temp=arr[left];
        arr[left]=baseNum;
        arr[left0]=temp;
        quickSort(arr,left0,left-1);
        quickSort(arr,left+1,right0);
    }
    @Test
    public void test(){
        int[]nums =new int[]{5,2,3,1};
        int[]mm=sortArray(nums);
        System.out.println(Arrays.toString(mm));
    }
}
