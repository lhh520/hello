package LCP;

import org.junit.Test;

import java.util.Arrays;

public class paixu {
    public void 冒泡(int[]nums){
        if(nums.length==0){
            return;
        }
        for(int i=0;i< nums.length;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j+1]<nums[j]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    //选择的排序
    public void 选择(int[]nums){
        if(nums.length==0){
            return;
        }
        for(int i=0;i<nums.length;i++){
            int min=i;
            for(int j=i;j<nums.length;j++){
                if(nums[j]>nums[min]){
                    min=j;
                }
            }
            if(min!=i){
                int temp=nums[i];
                nums[i]=nums[min];
                nums[min]=temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    //快速排序
    public void 快速排序(int[]nums,int left,int right){
        if(left>=right){
            return;
        }
        int left0=left;
        int right0=right;
        int baseNum=nums[left0];
        while (left!=right){
            while (left<right&&nums[right]>=baseNum){
                right--;
            }
            while (left<right&&nums[left]<=baseNum){
                left++;
            }
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        //将left 和 left0交换
        int temp=nums[left];
        nums[left]=nums[left0];
        nums[left0]=temp;
        快速排序(nums,left0,left-1);
        快速排序(nums,right+1,right0);
    }
    //
    public void 快速排序1(int[]nums,int left,int right){
        if(left>right){
            return;
        }
        int left0=left;
        int right0=right;
        int baseNum=nums[left0];
        while (left!=right){
            while (left<right&&nums[right]>=baseNum){
                right--;
            }
            while (left<right&&nums[left]<=baseNum){
                left++;
            }
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        int temp=nums[left];
        nums[left]=nums[left0];
        nums[left0]=temp;
        快速排序1(nums,left0,left-1);
        快速排序1(nums,right+1,right0);
    }
    public void 插入排序(int[]nums){
        if(nums.length==0){
            return;
        }
        int current;
        for(int i=0;i<nums.length-1;i++){
            current=nums[i+1];
            int preIndex=i;
            while (preIndex>0&&current<nums[preIndex]){
                nums[preIndex+1]=nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1]=current;
        }
    }
    int[]temp;
    public void 归并排序(int[]nums){
        temp=new int[nums.length];
        sort(nums,0,nums.length-1);
    }
    private void sort(int[]nums,int lo,int hi){
        if(lo==hi) return;
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,4,2,4,3};
        快速排序(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
