package testproject;

public class 二叉树中的最长交错路径 {
    private int max=0;
    public int longestZigZag(TreeNode root) {
        visited(root,0,0);
        return max;
    }
    public void visited(TreeNode root,int leftMax,int rightMax){
        max=Math.max(max,Math.max(leftMax,rightMax));
        if(root==null){
            return;
        }
        if(root.left!=null){
            visited(root.left,rightMax+1,0);
        }
        if(root.right!=null){
            visited(root.right,0,leftMax+1);
        }
    }

}
