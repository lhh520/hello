package Node;

public class test450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        TreeNode newRoot=root;
        TreeNode pre=root;
        while (root.val!=key){
            pre=root;
            if(root.val>key){
                root=root.left;
            }else if(root.val<key){
                root=root.right;
            }
        }

        return newRoot;

    }
}
