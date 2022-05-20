package 热题100;

import org.junit.Test;

import java.util.Arrays;

public class 颜色分类 {
    public void sortColors(int[] nums) {
        int r=0,w=0,b=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]==0){
                r++;
            }
            if(nums[i]==1){
                w++;
            }
            if(nums[i]==2){
                b++;
            }
        }
        //
        for(int i=0;i<nums.length;i++){
            if(i<r){
                nums[i]=0;
            }else if(i<(r+w)){
                nums[i]=1;
            }else {
                nums[i]=2;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,0,2,1,1,0};
        sortColors(nums);
    }
}
