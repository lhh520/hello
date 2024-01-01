package 新刷题;

import back.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode, ListNode t1) {
                return listNode.val-t1.val;
            }
        });
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
            pq.add(lists[i]);
        }
        ListNode dummy=new ListNode(0);
        ListNode node=dummy;
        while (!pq.isEmpty()){
            ListNode poll = pq.poll();
            node.next=poll;
            node=node.next;
            if(poll.next!=null){
                pq.add(poll.next);
            }
        }
        return dummy.next;
    }
}
