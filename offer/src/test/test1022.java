package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test1022 {
    int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    //parentPathSum表示从根节点到当前父节点这条路径表示的数字
    public void dfs(TreeNode root, int parentPathSum) {
        //如果节点为空，直接返回
        if (root == null)
            return;
        //父节点的值*2，在加上当前节点的值就是从根节点到
        //当前节点这条路径表示的数字
        int sum = parentPathSum * 2 + root.val;
        //如果到叶子节点，说明找到了一个从根节点到叶子
        //节点的完整路径，把这条路径的值加到res中
        if (root.left == null && root.right == null) {
            res += sum;
            return;
        }
        //如果没到叶子节点就继续遍历当前节点的左子节点和右子节点
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

   /* StringBuilder sb=new StringBuilder();
    List<String>list=new ArrayList<>();
    public int sumRootToLeaf(TreeNode root) {
        int sum=0;
        dfs(root);
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
            //int a=Integer.parseInt(list.get(i),2);
            //sum=sum+a;
        }
        return sum;
    }
    public void dfs(TreeNode root)
    {
        if(root==null)
        {
            //System.out.println(sb.toString());
            list.add(new String(sb.toString()));
            sb.delete(0,sb.length());
            return;
        }
        sb.append(root.val);
        dfs(root.left);
        dfs(root.right);
    }*/
    @Test
    public void test()
    {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(0);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(0);
        TreeNode f = new TreeNode(1);
        TreeNode g = new TreeNode(0);
        a.left = b;
        a.right = c;
        b.right = d;
        b.left = e;
        c.right = f;
        c.left = g;
        int aa=sumRootToLeaf(a);
        System.out.println(aa);
    }
}
