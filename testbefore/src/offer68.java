import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class offer68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     List<TreeNode>pathp=find(root,p);
     List<TreeNode>pathq=find(root,q);
     TreeNode anc=null;
     //找到了两个节点之后
     for(int i=0;i<pathq.size()&&i<pathp.size();i++)
     {
         if(pathp.get(i)==pathq.get(i))
             anc=pathp.get(i);
         else
             break;
     }
     return anc;
    }
    //在二叉树中寻找某一个值，等于当前的目标节点
    List<TreeNode>find(TreeNode root, TreeNode target)
    {   List<TreeNode>ans=new ArrayList<>();
        TreeNode node=root;
        while (node!=target)
        {
            ans.add(node);
            if(target.val<node.val)
                node=node.left;
            else
                node=node.right;
        }
        ans.add(node);
        return ans;
    }
    @Test
    public void test()
    {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.right = d;
        c.left = e;
        c.right = f;
        f.left = g;
        TreeNode ans=lowestCommonAncestor(a,b,c);
        System.out.println(ans.val);
    }
}
