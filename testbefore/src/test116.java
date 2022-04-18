import java.util.LinkedList;
import java.util.Queue;

public class test116 {
    public Node connect(Node root) {
        Queue<Node>queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
        int size= queue.size();
        //接下来每一层的遍历进行搜索
        for(int i=0;i<size;i++)
        {
            Node node=queue.poll();//取出队头元素
            if(i<size-1)
                node.next=queue.peek();//取出元素的下一个指向下一个队头元素，完成链接
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }}
        return root;
    }
}
