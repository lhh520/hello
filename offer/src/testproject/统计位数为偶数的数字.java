package testproject;

import org.junit.Test;

public class 统计位数为偶数的数字 {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(Integer.toString(nums[i]).length()%2==0){
                count++;
            }
        }
        return count;
    }
    @Test
    public void test(){
        int[]nums =new int[]{12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }
}
