import java.util.ArrayList;
import java.util.List;

public class test590 {
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
    List<Integer>list=new ArrayList<>();
    public List<Integer> postorder(Node root) {
    dfs(root);
    return list;
    }
    public void dfs(Node root)
    {
        if(root!=null)
        {
            for(Node cur:root.children)
            {
                if(cur!=null)
                    dfs(cur);
            }
            list.add(root.val);
        }
    }
}
