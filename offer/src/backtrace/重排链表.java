package backtrace;
import java.util.*;
public class 重排链表 {
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        List<ListNode>list=new ArrayList<>();
        ListNode node=head;
        while (node!=null){
            list.add(node);
            node=node.next;
        }
        int i=0,j=list.size()-1;
        while (i<j){
            list.get(i).next=list.get(j);
            i++;
            if(i==j){
                break;
            }
            list.get(j).next=list.get(i);
            j--;
        }
        list.get(i).next=null;
    }
    public void reorderList1(ListNode head){
        if(head==null){
            return;
        }
        //获取到了中间节点
        ListNode mid=middleNode(head);
        ListNode l1=head;
        ListNode l2=mid.next;
        mid.next=null;
        //得到了反转的链表
        l2=reverseList(l2);
        mergeList(l1,l2);
    }
    public ListNode middleNode(ListNode head) {
        //找到中间节点
        ListNode slow=head,fast=head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    //
    public ListNode reverseList(ListNode head){
        ListNode prev=null;
        while (head!=null){
            ListNode temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
    //将链表进行合并
    public void mergeList(ListNode l1, ListNode l2){
        ListNode l1_tmp,l2_tmp;
        while (l1!=null&&l2!=null){
            l1_tmp=l1.next;
            l2_tmp=l2.next;

            l1.next=l2;
            l1=l1_tmp;

            l2.next=l1;
            l2=l2_tmp;

        }
    }


}
