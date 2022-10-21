package back;
import java.util.*;
public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy=new ListNode(0,head);
        ListNode cur=dummy.next;
        while (cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
