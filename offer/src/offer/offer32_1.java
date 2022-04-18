package offer;

import org.junit.Test;

import java.util.*;

public class offer32_1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        List<List<Integer>>lists=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int i=0;
        while (!queue.isEmpty())
        {
            int sz=queue.size();

                for(int j=0;j<sz;j++)
                {
                    TreeNode temp=queue.poll();
                    list.add(temp.val);
                    if(temp.left!=null)
                        queue.add(temp.left);
                    if(temp.right!=null)
                        queue.add(temp.right);
                }

            if(i%2==0)
            lists.add(new ArrayList<>(list));
            else
                //lists.add(new ArrayList<>((Collections.reverse(list));
            {
                Collections.reverse(list);
                lists.add(new ArrayList<>(list));
            }
            list.clear();
            i++;
        }
        return lists;
    }
  //  @Test
    @Test
    public void test()
    {   TreeNode gg=null;
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
        List<List<Integer>>lists=levelOrder(gg);
        System.out.println(lists.toString());
    }
}
