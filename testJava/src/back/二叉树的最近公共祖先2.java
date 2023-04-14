package back;

public class 二叉树的最近公共祖先2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        if(root.val==p.val||root.val==q.val){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null){
            return root;
        }
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return null;
    }
}
