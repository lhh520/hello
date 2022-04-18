import apple.laf.JRSUIConstants;

import java.util.LinkedList;
import java.util.Queue;

public class test115 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        Queue<Node>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int sz= queue.size();
            //if(sz>1)
            Node temp=null;
            for(int i=0;i<sz;i++)
            {
                temp=new Node();
                temp=queue.poll();
                temp.next= queue.peek();
            }
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        return root;
    }
}
