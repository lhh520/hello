package test;

public class 最长同值路径 {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans=0;
        arrowLength(root);
        return ans;
    }
    public int arrowLength(TreeNode node){
        if(node==null) return 0;
        int left=arrowLength(node.left);
        int right=arrowLength(node.right);
        int arrLeft=0,arrRight=0;
        if(node.left!=null&&node.left.val==node.val){
            arrLeft+=left+1;
        }
        if(node.right!=null&&node.right.val==node.val){
            arrRight+=right+1;
        }
        ans=Math.max(ans,arrLeft+arrRight);
        return Math.max(arrLeft,arrRight);
    }
}
