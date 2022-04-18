package HW;

import org.junit.Test;

import java.util.Arrays;

public class Sort {
    //选择排序
    public void sort1(int[]nums){
        for(int i=0;i<nums.length-1;i++){
            int index=i;
            int j;
            //找出最小元素下标，与当前的进行交换。
            for(j=i+1;j<nums.length;j++){
                if(nums[j]<nums[index]){
                    index=j;
                }
            }
            int tem=nums[index];
            nums[index]=nums[i];
            nums[i]=tem;

        }
        System.out.println(Arrays.toString(nums));
    }
    //冒泡排序
    public void sort2(int[]nums){
    if(nums.length==0)
        return;
    for(int i=0;i<nums.length;i++){
        for(int j=0;j<nums.length-i-1;j++){
            if(nums[j+1]<nums[j]){
                int tem=nums[j+1];
                nums[j+1]=nums[j];
                nums[j]=tem;
            }
        }
    }
        System.out.println(Arrays.toString(nums));
    }
    //插入排序
    public void sort3(int[]nums){
        if(nums.length==0){
            return;
        }
        int current;
        for(int i=0;i<nums.length-1;i++){
            current=nums[i+1];
            int preIndex=i;
            while (preIndex>=0&&current<nums[preIndex]){
                nums[preIndex+1]=nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1]=current;
        }
        System.out.println(Arrays.toString(nums));
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,3,2,4,5};
        sort2(nums);
    }
}
