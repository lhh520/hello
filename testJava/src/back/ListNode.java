package back;

public  class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x)
    {
        val=x;
        next=null;
    }
    public ListNode(int val, ListNode next)
    {
         this.val=val;
         this.next=next;
    }
    /*
     ListNode n4=new ListNode(1);
        ListNode n3=new ListNode(2,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
    * */
}
