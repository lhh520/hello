package 热题100;

import org.junit.Test;

public class 求根节点到叶节点数字之和 {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root,0);
        return sum;
    }
    public void dfs(TreeNode root,int cur){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){//已经到了根部了
            cur=cur*10+root.val;
            sum=sum+cur;
            return;
        }
        cur=cur*10+root.val;
        dfs(root.left,cur);
        dfs(root.right,cur);
    }
    @Test
    public void test(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
//        TreeNode d = new TreeNode(4);
//        TreeNode e = new TreeNode(5);
//        TreeNode f = new TreeNode(6);
//        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
//        b.right = d;
//        c.left = e;
//        c.right = f;
//        f.left = g;
        System.out.println(sumNumbers(a));
    }
}
