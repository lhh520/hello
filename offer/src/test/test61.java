package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test61 {
    public static ListNode rotateRight(ListNode head, int k) {
    ListNode h1=head;
    int len=0;
List<ListNode>list=new ArrayList<>();
    while (h1!=null)
    {
       len++;
       list.add(h1);
       h1=h1.next;
    }
    System.out.println(len);
    k=k%len;
    for(int i=0;i<k;i++)
    {   //暂时存储最后一位的数字
        ListNode temp=list.get(list.size()-1);
        for (int j = list.size()-1; j >0 ; j--) {
            list.set(j,list.get(j-1));
        }
        list.set(0,temp);
    }

    ListNode pre=new ListNode(0);
    ListNode cur=pre;

        System.out.println(1);
        for (int i = 0; i <list.size(); i++) {
            ListNode temp=list.get(i);
            cur.next=temp;
            cur=temp;
        }
        cur.next=null;
    return pre.next;
    }
    public static void main(String[] args) {
        ListNode n5=new ListNode(5);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode n=rotateRight(n1,2);
        while (n!=null)
        {
            System.out.print(n.val+"  ");
            n=n.next;
        }
    }
}
