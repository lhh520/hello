package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class 所有奇数长度子数组的和 {
    List<Integer> list=new ArrayList<>();
    public int sumOddLengthSubarrays(int[] arr) {
        int sum=0;
        int n=arr.length;
       for(int start=0;start<n;start++){
           for(int length=1;length+start<=n;length+=2){
               int end=start+length-1;
               for(int i=start;i<=end;i++){
                   sum=sum+arr[i];
               }
           }
       }
       return sum;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(nums));
    }
}
