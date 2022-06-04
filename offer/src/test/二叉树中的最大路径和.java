package test;

public class 二叉树中的最大路径和 {
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        maxGain(root);
        return maxsum;
    }
    public int maxGain(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftGain=Math.max(maxGain(root.left),0);
        int rightGain=Math.max(maxGain(root.right),0);
        int price=root.val+leftGain+rightGain;
        maxsum=Math.max(maxsum,price);
        return root.val+Math.max(leftGain,rightGain);
    }
}
