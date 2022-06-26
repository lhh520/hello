package testproject;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树与双向链表 {
    List<Node>list=new ArrayList<>();
    Node head;
    public Node treeToDoublyList(Node root) {
        //中序遍历
        dfs(root);
        Node l1=list.get(1);
        Node l2=list.get(list.size()-1);
        Node min=new Node(Integer.MAX_VALUE);
        for(int i=0;i<list.size();i++){
            if(i==0){

                Node temp=list.get(i);
                if(min.val>temp.val){
                    min=temp;
                }
                Node temp2=list.get(i+1);
                temp.left=l2;
                temp.right=temp2;
                continue;
            }
            if(i==list.size()-1){

                Node temp=list.get(i);
                if(min.val>temp.val){
                    min=temp;
                }
                Node temp2=list.get(i-1);
                temp.left=temp2;
                temp.right=l1;
                continue;
            }
            Node temp=list.get(i);
            if(min.val>temp.val){
                min=temp;
            }
            Node temp1=list.get(i-1);
            Node temp2=list.get(i+1);
            temp.left=temp1;
            temp.right=temp2;
        }

        head.left=list.get(0);
        return head;
    }
    public void dfs(Node root){
        if(root==null){
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}

