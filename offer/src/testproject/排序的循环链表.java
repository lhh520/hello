package testproject;

import org.junit.Test;

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
public class 排序的循环链表 {
    public Node insert(Node head, int insertVal) {
       if(head==null){
           Node node=new Node(insertVal);
           return node;
       }
       Node cur=head;
       //分三种情况，处于两者之间
       while (cur.next!=head){
            if(cur.next.val<cur.val){
                if(cur.next.val>=insertVal){
                   //最小值
                    //[3,5,1] 0
                    break;
                }else if(cur.val<=insertVal){
                    break;
                }
            }
            //中间顺序插入
           if(cur.val<=insertVal&&cur.next.val>=insertVal){
               break;
           }
           cur=cur.next;
       }
       //插入新的节点
        cur.next=new Node(insertVal,cur.next);
        return head;
    }
    @Test
    public void test(){
        Node n3=new Node(1);
        Node n2=new Node(4,n3);
        Node n1=new Node(3,n2);
        n3.next=n1;
        insert(n1,2);

    }
}
