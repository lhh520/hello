package 代码随想录二刷.链表;

public class 设计链表 {

    int size;
    ListNode l1;
    public 设计链表(){
        size=0;
        l1=new ListNode(0);
    }
    public int get(int index){
        if(index>=size||index<0){
            return -1;
        }
        ListNode cur=l1;
        while (index>0){
            l1=l1.next;
            index--;
        }
        return 0;
    }
}
