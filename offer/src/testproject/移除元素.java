package testproject;

import org.junit.Test;

public class 移除元素 {
    public int removeElement(int[] nums, int val){
        int size=nums.length;
        for(int i=0;i<size;i++){
            if(nums[i]==val){
                for(int j=i+1;j<size;j++){
                    nums[j-1]=nums[j];
                }
                size--;
                i--;
            }
        }
        return size;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,1,1,1,1};
        //System.out.println(removeElement(nums,1));
        int mm=removeElement(nums,1);
        System.out.println(mm);
    }
}
