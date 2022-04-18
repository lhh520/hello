package nums;

import org.junit.Test;

import java.util.Arrays;

public class test27 {
    public int removeElement(int[] nums, int val) {
        int size=nums.length;
        for(int i=0;i<size;i++){
            if(nums[i]==val){
                for(int j=i+1;j<size;j++){
                    nums[j-1]=nums[j];
                }
                i--;
                size--;
            }
        }

        return size;
    }

    @Test
    public void test(){
        int[]nums =new int[] {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums,val));
    }
}
