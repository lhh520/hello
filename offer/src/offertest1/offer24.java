package offertest1;

import org.junit.Test;

public class offer24 {
    public ListNode reverseList(ListNode head) {
    ListNode newhead=null;
    ListNode cur=head;
    while (cur!=null){
        ListNode temp=cur.next;
        cur.next=newhead;
        newhead=cur;
        cur=temp;
    }
    return newhead;
    }
    @Test
    public void test(){
        ListNode n5=new ListNode(5);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode nn=reverseList(n1);
        while (nn!=null){
            System.out.println(nn.val);
            nn=nn.next;
        }
    }
}
