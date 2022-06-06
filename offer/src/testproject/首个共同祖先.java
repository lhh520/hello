package testproject;

public class 首个共同祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p||root==q){
            return root;//表示已经遇到了
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.left,p,q);
        if(left!=null&&right!=null){
            return root;
        }
        return left!=null?left:right;
    }
}
