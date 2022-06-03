package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        }
        preSum=0;
        for(d=dummy;d!=null;d=d.next){
            preSum+=d.val;
            d.next=map.get(preSum).next;
        }
        return dummy.next;
    }
    @Test
    public void test(){
        ListNode n5=new ListNode(1);
        ListNode n4=new ListNode(3,n5);
        ListNode n3=new ListNode(-3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        removeZeroSumSublists(n1);
    }
}
