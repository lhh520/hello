import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test429 {
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
    public List<List<Integer>> levelOrder(Node root) {
       Queue<Node>queue=new LinkedList<>();
        List<Integer>list=new ArrayList<>();
        List<List<Integer>>lists=new ArrayList<>();
       queue.add(root);
       while(!queue.isEmpty())
       {  int sz=queue.size();
           for(int i=0;i<sz;i++)
           { Node node=queue.poll();
             list.add(node.val);

             for(Node n:node.children)
             {
                 queue.add(n);
             }
          }
          lists.add(new ArrayList<>(list));
           list.clear();
       }
       return lists;
    }
}
