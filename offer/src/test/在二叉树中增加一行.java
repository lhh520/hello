package test;

public class 在二叉树中增加一行 {
    public TreeNode addOneRow(TreeNode root, int val, int depth){
        if(depth==1){
            TreeNode newroot=new TreeNode(val);
            newroot.left=root;
            return newroot;
        }
        insert(root,val,1,depth);
        return root;
    }
    public void insert(TreeNode root,int val,int depth,int n){
        if(root==null){
            return;
        }
        if(depth==n-1){
            TreeNode t=root.left;
            root.left=new TreeNode(val);
            root.left.left=t;
            t=root.right;
            root.right=new TreeNode(val);
            root.right.right=t;
        }else {
            insert(root.left,val,depth+1,n);
            insert(root.right,val,depth+1,n);
        }
    }
}
