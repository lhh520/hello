package test;

public class 删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur=root;
        TreeNode pre=cur;
        while (cur.val!=key){
            pre=cur;
            if(cur.val>key){
                cur=cur.left;
            }else {
                cur=cur.right;
            }
        }
        //如果为叶子节点
        if (cur == null) {
            return root;
        }
        if (cur.left == null && cur.right == null) {
            cur = null;
        } else if (cur.right == null) {
            cur = cur.left;
        } else if (cur.left == null) {
            cur = cur.right;
        } else {
            TreeNode successor = cur.right, successorParent = cur;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            if (successorParent.val == cur.val) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
            successor.right = cur.right;
            successor.left = cur.left;
            cur = successor;
        }
        if (pre == null) {
            return cur;
        } else {
            if (pre.left != null && pre.left.val == key) {
                pre.left = cur;
            } else {
                pre.right = cur;
            }
            return root;
        }


    }
    //
    public TreeNode deleteNode1(TreeNode root, int key){
        if(root==null){
            return null;
        }
        if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else {//遇到了当前要删除的节点
            if(root.left==null){
                return root.right;//跳过当前值 就相当于删除了当前值
            }else if(root.right==null){
                return root.left;
            }else if(root.left!=null&&root.right!=null){//左右都不为空
                TreeNode node=root.right;
                while (node.left!=null){
                    node=node.left;
                }
                node.left=root.left;
                root=root.right;
            }
        }
        return root;
    }
}
