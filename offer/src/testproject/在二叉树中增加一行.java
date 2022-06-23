package testproject;

public class 在二叉树中增加一行 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){//如果深度等于1，则说明可以直接插入第一行
            TreeNode newroot=new TreeNode(val);//新的深度情况
            newroot.left=root;//新节点的左边就是最大值 直接退出
            return newroot;
        }
        //递归寻找新的深度
        insert(root,val,1,depth);
        return root;
    }
    public void insert(TreeNode root, int val, int depth,int n){
        if(root==null){
            return;
        }
        if(depth==n-1){//找到相应的深度
            TreeNode t=root.left;
            root.left=new TreeNode(val);//新的左边的节点
            root.left.left=t;
            t=root.right;//获取右侧节点
            root.right=new TreeNode(val);
            root.right.right=t;//右侧归位
        }else {
            insert(root.left,val,depth+1,n);
            insert(root.right,val,depth+1,n);
        }
    }
}
