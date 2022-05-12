package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 使数组唯一的最小增量 {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int move=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]<=nums[i]){
                int pre=nums[i+1];
                nums[i+1]=nums[i]+1;
                move=move+nums[i+1]-pre;
            }
        }
        return move;
    }
    public int minIncrementForUnique1(int[] nums){
        int[]count=new int[40001];
        int max=-1;
        int move=0;
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
            max=Math.max(max,nums[i]);
        }
        for(int i=0;i<=max;i++){
            if(count[i]>1){
                int d=count[i]-1;
                move+=d;
                count[i+1]=count[i+1]+d;
            }
        }
        return move;
    }

    @Test
    public void test(){
        int[]nums=new int[]{3,2,1,2,1,7};
        System.out.println(minIncrementForUnique1(nums));
    }
}
