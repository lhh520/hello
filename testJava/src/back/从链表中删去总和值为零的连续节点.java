package back;
import java.util.*;
public class 从链表中删去总和值为零的连续节点 {
    public ListNode removeZeroSumSublists(ListNode head) {
        int preSum=0;
        Map<Integer,ListNode>map=new HashMap<>();
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode d=dummy;
        while (d!=null){
            preSum=preSum+d.val;
            map.put(preSum,d);
            d=d.next;
        }
        preSum=0;
        for(d=dummy;d!=null;d=d.next){
            preSum+=d.val;
            d.next=map.get(preSum).next;
        }
        return dummy.next;

    }
    //
    public ListNode removeZeroSumSublists1(ListNode head) {
        int preSum=0;
        Map<Integer,ListNode>map=new HashMap<>();
        ListNode dummy=new ListNode(0,head);
        ListNode d=dummy;
        while (d!=null){
            preSum+=d.val;
            map.put(preSum,d);
            d=d.next;
        }
        preSum=0;
        for(d=dummy;d!=null;d=d.next){
            preSum+=d.val;
            d.next=map.get(preSum);
        }
        return dummy.next;
    }
}
