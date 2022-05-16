package 热题100;

import org.junit.Test;

public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1=list1;
        ListNode l2=list2;
        ListNode pre=new ListNode(0);
        ListNode cur=new ListNode(0);
        cur=pre;
        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                ListNode temp=new ListNode(l1.val);
                cur.next=temp;
                cur=cur.next;
                l1=l1.next;
            }
            else {
                ListNode temp=new ListNode(l2.val);
                cur.next=temp;
                cur=cur.next;
                l2=l2.next;
            }
        }
        if(l1!=null){
            cur.next=l1;
        }else {
            cur.next=l2;
        }
        return pre.next;
    }
    @Test
    public void test(){
        ListNode n4=new ListNode(4);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        //
        ListNode n0=mergeTwoLists(n1,n2);
        while (n0!=null){
            System.out.println(n0.val);
            n0=n0.next;
        }
    }
}
