package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 排序链表 {
    public ListNode sortList(ListNode head) {
        ListNode cur=head;
        List<ListNode>list=new ArrayList<>();
        while (cur!=null){
            list.add(cur);
            cur=cur.next;
        }
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val- o2.val;
            }
        });
        ListNode dummy=new ListNode(0);
        cur=dummy;
        for(int i=0;i<list.size();i++){
            ListNode temp=list.get(i);
            cur.next=temp;
            cur=cur.next;
        }
        cur.next=null;
        //System.out.println(11);
        return dummy.next;
    }
    @Test
    public void test(){
        ListNode n4=new ListNode(1);
        ListNode n3=new ListNode(2,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        System.out.println(sortList(n1));
    }
}
