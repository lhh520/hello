package test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 合并排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;//从小到大排列
            }
        });
        for(ListNode listNode:lists){
            if(listNode!=null)
            pq.add(listNode);
        }
        ListNode dummy=new ListNode(0);
        ListNode p=dummy;
        while (!pq.isEmpty()){
            p.next=pq.poll();
            p=p.next;
            if(p.next!=null) pq.add(p.next);
        }
        return dummy.next;
    }
}
