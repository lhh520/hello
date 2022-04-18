import java.util.HashMap;

public class test138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
     if(head==null)
         return null;
     Node cur=head;
     HashMap<Node,Node>map=new HashMap<>();
     while(cur!=null)//提前创建好所有的节点，并进行对应
     {
         map.put(cur,new Node(cur.val));
         cur=cur.next;
     }
     cur=head;
     while(cur!=null)
     {
         map.get(cur).next=map.get(cur.next);
         map.get(cur).random=map.get(cur.random);
         cur=cur.next;
     }
     return  map.get(head);
    }
}
