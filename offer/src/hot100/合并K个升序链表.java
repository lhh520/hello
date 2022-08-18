package hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode listNode:lists){
            pq.add(listNode);
        }
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while (!pq.isEmpty()){
            ListNode top=pq.poll();
            cur.next=top;
            cur=cur.next;
            if(top.next!=null){
                pq.add(top.next);
            }
        }
        return dummy.next;
    }

}
