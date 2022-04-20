package Node;

public class test701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val>val){
            insertIntoBST(root.left,val);
        }else if(root.val<val){
            insertIntoBST(root.right,val);
        }
        return root;
    }
    public TreeNode insertIntoBST1(TreeNode root, int val){
        if(root==null) return new TreeNode(val);
        TreeNode newRoot=root;
        TreeNode pre=root;
        while (root!=null){
            pre=root;
            if(root.val>val){
                root=root.left;
            }else if(root.val<val){
                root=root.right;
            }
        }
        if(pre.val>val){
            pre.left=new TreeNode(val);
        }else {
            pre.right=new TreeNode(val);
        }
        return newRoot;
    }
}
