package offertest1;

import org.junit.Test;

public class offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null)
            return null;
      ListNode pre=new ListNode(0);
      pre.next=head;
      ListNode cur=head;
      int length=0;
      while (cur!=null){
          cur=cur.next;
          length++;
      }
        cur=head;
      int m=length-k;
        while (m>0){
            cur=cur.next;
            m--;
        }
        return cur;
    }
    @Test
    public void test(){
        ListNode n5=new ListNode(5);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode nn=getKthFromEnd(n1,2);
        while (nn!=null){
            System.out.println(nn.val);
            nn=nn.next;
        }
    }
}
