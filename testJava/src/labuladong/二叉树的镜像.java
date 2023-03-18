package labuladong;

public class 二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp=root.left;
        root.left=mirrorTree(root.right);
        root.right=mirrorTree(temp);
        return root;
    }
}
