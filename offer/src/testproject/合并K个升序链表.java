package testproject;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }
    //
    public ListNode mergeKLists1(ListNode[] lists){
        if(lists==null||lists.length==0) return null;
        PriorityQueue<ListNode>q=new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        for(ListNode node:lists){
            if (node != null) q.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (!q.isEmpty()){
            p.next=q.poll();
            p=p.next;
            if(p.next!=null) q.add(p.next);
        }
        return dummy.next;
    }


}
