package test2022;

public class 链表反转 {
    public ListNode reverseList(ListNode head){
        ListNode pre=null;
        while (head!=null){
            ListNode temp=head.next;
            head.next=pre;
            pre=head;
            head=temp;
        }
        return pre;
    }
}
