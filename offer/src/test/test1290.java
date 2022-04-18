package test;

import org.junit.Test;

import java.util.List;

public class test1290 {
    public int getDecimalValue(ListNode head) {
        if(head==null){
            return 0;
        }
        ListNode pre=head;
        int sum=0;
        while (pre!=null){
           sum=sum*2+pre.val;
           pre=pre.next;
        }
        return sum;
    }
    @Test
    public void test(){
        ListNode n3=new ListNode(1);
        ListNode n2=new ListNode(0,n3);
        ListNode n1=new ListNode(1,n2);
        System.out.println(getDecimalValue(n1));
    }
}
