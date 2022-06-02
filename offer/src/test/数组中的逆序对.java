package test;

import org.junit.Test;

public class 数组中的逆序对 {
    public int reversePairs(int[] nums) {
        int count=0;
        for(int i=0;i< nums.length-1;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    count++;
                }
            }
        }
        return count;
    }
    //
    int count=0;
    public int reversePairs1(int[] nums){
        this.count=0;
        sort(nums,0,nums.length-1,new int[nums.length]);
        return count;
    }
    public void sort(int[]nums,int left,int right,int[]temp){
        if(left<right){
            int mid=(left+right)/2;
            sort(nums,left,mid,temp);//左边归并排序
            sort(nums,mid+1,right,temp);//右边归并排序
            merge(nums,left,mid,right,temp);
        }
    }
    public void merge(int[]nums,int left,int mid,int right,int[]temp){
        int i=left;
        int j=mid+1;
        int t=0;
        while (i<=mid&&j<=right){
            if(nums[i]<=nums[j]){//正序对
                temp[t++]=nums[i++];
            }else {
                count+=(mid-i+1);//需要加的数字
                temp[t++]=nums[j++];
            }
        }
        //只剩下做和右
        while (i<=mid){
            temp[t++]=nums[i++];
        }
        while (j<=right){
            temp[t++]=nums[j++];
        }
        t=0;
        while (left<=right){
            nums[left++]=temp[t++];
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{7,5,6,4};
        System.out.println(reversePairs1(nums));
    }
}
