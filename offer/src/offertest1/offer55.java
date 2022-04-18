package offertest1;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class offer55 {
    int depth=0;
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int sz=queue.size();
            depth++;
            for(int i=0;i<sz;i++){
                TreeNode temp=queue.poll();
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
        }
        return depth;
    }
    public int maxDepth1(TreeNode root){
        if(root==null)
            return 0;
        return  dfs(root,0);
        //return depth;

    }
    public int dfs(TreeNode root,int depth){
        if(root==null)
            return depth;
        return Math.max(dfs(root.left,depth+1),dfs(root.right,depth+1));
    }
    @Test
    public void test(){
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
        int aa=maxDepth(a);
        System.out.println(aa);

    }
}
