package LCP;

public class teesss {
    class ListNode<T> {
        public T data;
        public ListNode next;
    }
    int i=0;

    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        i++;
        if(i==right){
            return head;
        }
        if(i<left){
            head.next=reverseBetween(head.next,left,right);
            return head;
        }else {
            ListNode<Integer>node=reverseBetween(head.next,left,right);
            ListNode<Integer>nex=head.next.next;
            head.next.next=head;
            head.next=nex;
            return node;
        }

    }





}
