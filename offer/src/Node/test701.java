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
}
