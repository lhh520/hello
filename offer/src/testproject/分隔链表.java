package testproject;

import org.junit.Test;

import java.util.List;

public class 分隔链表 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int total=0;
        ListNode[] lists=new ListNode[k];
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=head;
        while(cur!=null){
            total++;
            cur=cur.next;
        }
        int mini=total/k;
        if(mini==0){
            mini++;
        }
        int n=total-mini*k;
        cur=dummy.next;
        int j=0;
        while (total>0){
            int ii=mini;
            lists[j]=cur;
            j++;
            while (ii>0){
                cur=cur.next;
                ii--;
            }
            if(cur!=null&&cur.next!=null){
                break;
            }
            ListNode temp=cur.next;
            cur.next=null;
            cur=temp;
            total-=ii;
        }
        while (lists.length<k){
            lists[j++]=null;
        }
        return lists;
    }

}
