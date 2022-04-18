import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node root) {
        if(root==null)
            return 0;
        if(root.children.isEmpty())
            return 1;
    int depth=dfs(root);
    return depth;
    }
    public int dfs(Node root)
    {

        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<root.children.size();i++)
        {
            //return Math.max(dfs(root.children.get(i)))+1;
            ans.add(dfs(root.children.get(i)));

        }
        return Collections.max(ans)+1;
    }
    public List<Integer> preorder(Node root) {
     List<Integer>ans=new ArrayList<>();
     dfs1(root,ans);
     return ans;
    }
    public void dfs1(Node root,List<Integer>ans)
    {
        if(root==null)
            return;
        if(root.children.isEmpty())
        {
            ans.add(root.val);
            return;
        }
        ans.add(root.val);
        for(Node temp:root.children)
        {
            dfs1(root,ans);
        }
    }
}
