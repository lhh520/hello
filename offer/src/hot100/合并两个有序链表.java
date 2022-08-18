package hot100;

import java.util.List;

public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1=list1,cur2=list2;
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while (cur1!=null||cur2!=null){
            int node1=cur1==null?Integer.MAX_VALUE:cur1.val;
            int node2=cur2==null?Integer.MAX_VALUE:cur2.val;
            if(node1<node2){
                cur.next=cur1;
                cur=cur.next;
                if(cur1!=null){
                    cur1=cur1.next;
                }
            }else {
                cur.next=cur2;
                cur=cur.next;
                if(cur2!=null){
                    cur2=cur2.next;
                }
            }
        }
        return dummy.next;
    }
}
