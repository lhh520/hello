package test;

import org.junit.Test;

public class test92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre=new ListNode(-1);
        pre.next=head;
        ListNode cur1=pre;
       int t1=0;
       while(t1<left-1)
       {   t1++;
           cur1=cur1.next;
       }
       //保存第一个节点
       ListNode leftNode=cur1;
        System.out.println(cur1.val);
       while (t1<right)
       {
           cur1=cur1.next;
           t1++;
       }
       //保存right后面的节点的第一个节点
       ListNode rightNode=cur1.next;
        System.out.println(rightNode.val);
       //链表切断
       cur1.next=null;
       ListNode newhead=leftNode.next;
       leftNode.next=null;
       //进行反转
        leftNode.next=reverse(newhead);
        //接头
        newhead.next=rightNode;
        return pre.next;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode temp=head;
        ListNode result=null;
        while (temp!=null)
        {
            ListNode hh=temp;
            temp=temp.next;
            hh.next=result;
            result=hh;
        }
        return result;
    }

    @Test
    public void test()
    {   ListNode n5=new ListNode(5);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode head=reverseBetween(n1,2,4);
        while (head!= null)
        {
            System.out.println(head.val);
            head=head.next;
        }
        }
    }

