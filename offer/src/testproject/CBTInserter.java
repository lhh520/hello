package testproject;

import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter {
    Queue<TreeNode>candidate;
    TreeNode root;
    public CBTInserter(TreeNode root) {
       this.candidate=new LinkedList<>();
       this.root=root;
       Queue<TreeNode>queue=new LinkedList<>();
       queue.add(root);
       while (!queue.isEmpty()){
           TreeNode node=queue.poll();
           if(node.left!=null){
               queue.offer(node.left);
           }
           if(node.right!=null){
               queue.offer(node.right);
           }
           if(!(node.left!=null&&node.right!=null)){//存储的是最后一层
               candidate.offer(node);
           }
       }
    }

    public int insert(int val) {
        TreeNode child=new TreeNode(val);
        TreeNode node=candidate.peek();
        int ret=node.val;
        if(node.left==null){
            node.left=child;
        }else {
            node.right=child;
            candidate.poll();//表示这个树满了
        }
        candidate.offer(child);//插入进入的必然不是满的
        return ret;
    }

    public TreeNode get_root() {
        return root;
    }
}
