package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 重排链表 {
    public void reorderList(ListNode head) {
        List<ListNode>list=new ArrayList<>();
        if(head==null||head.next==null){
            return;
        }
        ListNode cur=head;
        while (cur!=null){
            list.add(cur);
            cur=cur.next;
        }
        //得到list
        ListNode pre=new ListNode(-1);
        ListNode temp=pre;

        int left=0,right=list.size()-1;
        while (left<right){
            ListNode l1=list.get(left);
            ListNode l2=list.get(right);
            temp.next=l1;
            temp.next.next=l2;
            temp=l2;
            left++;
            right--;
        }
        //System.out.println("log"+list.size());

        if(list.size()%2!=0){
            //System.out.println(temp.val);
            temp.next=list.get(list.size()/2);
            temp=temp.next;
        }
        temp.next=null;
        cur=pre.next;
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    @Test
    public void test(){
//        ListNode n5=new ListNode(5);
//        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        reorderList(n1);
    }
}
