package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        Queue<Node>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int sz=queue.size();
            List<Node>list=new ArrayList<>();
            for(int i=0;i<sz;i++){
                Node temp=queue.poll();
                list.add(temp);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            for(int i=0;i<list.size()-1;i++){
                list.get(i).next=list.get(i+1);
            }
            list.get(list.size()-1).next=null;
        }
        return root;
    }
}
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
