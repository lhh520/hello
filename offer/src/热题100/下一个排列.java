package 热题100;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        int next1=0;
        //找到第一个逆序的数
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i-1]<nums[i]){
                next1=i-1;
                //System.out.println(nums[i-1]);
                break;
            }
        }
        //从 length 到 next1 找到仅大于next
        System.out.println(next1);
        int next2=next1;
        int min=Integer.MAX_VALUE;
        for(int i=next1+1;i<nums.length;i++){
            int temp=nums[i]-nums[next1];
            if(temp>0&&temp<min){
                min=temp;
                next2=i;
            }
        }
        if(next1==next2){
            Arrays.sort(nums);
            return;
        }
        //System.out.println(next2);
        //交换next1 和 next2 交换完成
        int temp=nums[next1];
        nums[next1]=nums[next2];
        nums[next2]=temp;
        //从next2 开始排序
        System.out.println(next2);
        Arrays.sort(nums,next1+1,nums.length);
        System.out.println(Arrays.toString(nums));
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,2,1};
//        Arrays.sort(nums,1,nums.length);
//        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
    }
}
