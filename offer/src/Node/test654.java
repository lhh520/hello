package Node;

import org.junit.Test;

public class test654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree1(nums,0,nums.length);
    }
    public TreeNode constructMaximumBinaryTree1(int[] nums,int left,int right){
         if(right-left<1)
             return null;
         if(right-left==1){//只有一个元素
             return new TreeNode(nums[left]);
         }
         int maxIndex=left;
         int maxval=nums[left];
         for(int i=left+1;i<right;i++){//找到最大元素
             if(nums[i]>maxval){
                 maxval=nums[i];
                 maxIndex=i;
             }
         }
         TreeNode root=new TreeNode(maxval);
         root.left=constructMaximumBinaryTree1(nums,left,maxIndex);
         root.right=constructMaximumBinaryTree1(nums,maxIndex+1,right);
         return root;
    }


}
