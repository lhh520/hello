package labuladong;

import java.util.List;

public class 删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode cur=head;
        while (cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
        return head;
    }
    public ListNode deleteDuplicates1(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(0,head);
        ListNode cur=dummy;
        while (cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int x=cur.next.val;
                while (cur.next!=null&&cur.next.next.val==x){
                    cur.next=cur.next.next;
                }
            }else {
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
