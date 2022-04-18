package test;

import java.util.ArrayList;
import java.util.List;

public class test423 {
    public int[] twoSum(int[] numbers, int target) {
    int left=0,right=numbers.length-1;
    while(left<right){
        if(numbers[left]+numbers[right]>target){
            right--;
            continue;
        }
        if(numbers[left]+numbers[right]<target){
            left++;
            continue;
        }
        if(numbers[left]+numbers[right]==target){
            return new int[]{left,right};
        }
    }
    return new int[]{-1,-1};
    }
}
