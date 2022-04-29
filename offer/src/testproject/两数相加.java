package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node1=l1;
        ListNode node2=l2;
        ListNode pre=new ListNode(-1);
        ListNode curNode=pre;
        int ad=0;
        while (node1!=null||node2!=null){
            int val1=node1==null?0:node1.val;
            int val2=node2==null?0:node2.val;
            int cur=(ad+val1+val2)%10;
            ad=(val1+val2)/10;
            //list.add(cur);
            ListNode temp=new ListNode(cur);
            curNode.next=temp;
            curNode=curNode.next;
            if(node1!=null){
                node1=node1.next;
            }
            if(node2!=null){
                node2=node2.next;
            }
        }
        if(ad>0){
            ListNode temp=new ListNode(ad);
            curNode.next=temp;
        }

        return pre.next;
    }
    @Test
    public void test(){
        ListNode n4=new ListNode(1);
        ListNode n3=new ListNode(2,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode yy=addTwoNumbers(n1,n1);
        while (yy!=null){
            System.out.println(yy.val);
            yy=yy.next;
        }
    }
}
