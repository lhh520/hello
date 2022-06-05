package test;

public class 分割链表 {
    public ListNode partition(ListNode head, int x) {
        //使用两个
        //小于x的值
        ListNode dummy1=new ListNode(0);
        ListNode cur1=dummy1;
        ListNode dummy2=new ListNode(0);
        ListNode cur2=dummy2;
        ListNode cur=head;
        while (cur!=null){
            if(cur.val<x){
                cur1.next=cur;
                cur1=cur1.next;
            }else {
                cur2.next=cur;
                cur2=cur2.next;
            }
            cur=cur.next;
        }
        cur1.next=dummy2.next;
        cur2.next=null;
        return dummy1.next;
    }
}
