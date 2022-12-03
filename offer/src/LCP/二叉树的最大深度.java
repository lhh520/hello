package LCP;


import org.junit.Test;

import java.util.Arrays;

public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public void QuickSort(int[]nums,int left,int right){
        if(left>right){
            return;
        }
        int baseNum=nums[left];
        int left0=left,right0=right;
        while (left<right){
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
        QuickSort(nums,0,left-1);
        QuickSort(nums,left+1,right0);
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,3,2,13,4,3};
        QuickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
