import java.util.LinkedList;
import java.util.Queue;

public class test993 {
    /*public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int sz=queue.size();
            TreeNode temp=null;
            int flag=0;
            int index1=0,index2=0;
            for(int i=0;i<sz;i++)
            {
                temp=queue.poll();
                if(temp.val==x)
                {flag++;
                    index1=i;
                }
                if(temp.val==y)
                {   flag++;
                    index2=i;
                }
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
            }
            if(flag==2&&Math.abs(index1-index2)!=1)
                return true;
        }
        return false;
    }*/
    /*TreeNode first=null,second=null;
    public boolean isCousins1(TreeNode root, int x, int y)
    {
        int d1=dfs(root,x);
    }
    public int dfs(TreeNode root,int x)
    {
        if(root==null)
            return 0;
        if(root.left.val==x||root.right.val==x)
        {
            first=root;
            return d1;
        }
    }*/
}
