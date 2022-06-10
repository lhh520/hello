package testproject;

import org.junit.Test;

import java.util.List;

public class test02 {
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
        //三种情况 3/5
        //整初
        //余数为
        if(mini==0){
            mini++;
        }
        int n=total-mini*k;//应该平均分给前面的 n一定小于k
        cur=dummy.next;
        int j=0;
        while (total>0){
            int ii=mini;
            if(n>0){//表示向前加
                n--;
                ii++;
            }
            lists[j++]=cur;//表示获取到最新的头节点
            while (ii>0){
                if(ii==1){
                    cur.next=null;
                }
                cur=cur.next;

                ii--;
            }
            if(cur==null||cur.next==null){
                break;
            }
//            ListNode temp=cur.next;
//            cur.next=null;
//            cur=temp;
            total-=ii;
        }
        while (lists.length<k){
            lists[j++]=null;
        }
        System.out.println(1);
        return lists;
    }
    public ListNode[] splitListToParts1(ListNode head, int k) {
        // 扫描链表，得到总长度 cnt
        int cnt = 0;
        ListNode tmp = head;
        while (tmp != null && ++cnt > 0) tmp = tmp.next;
        // 理论最小分割长度
        int per = cnt / k;
        // 将链表分割为 k 份（sum 代表已经被处理的链表长度为多少）
        ListNode[] ans = new ListNode[k];
        for (int i = 0, sum = 1; i < k; i++, sum++) {
            ans[i] = head;
            tmp = ans[i];
            // 每次首先分配 per 的长度
            int u = per;
            while (u-- > 1 && ++sum > 0) tmp = tmp.next;
            // 当「已处理的链表长度 + 剩余待分配份数 * per < cnt」，再分配一个单位长度
            int remain = k - i - 1;
            if (per != 0 && sum + per * remain < cnt && ++sum > 0) tmp = tmp.next;
            head = tmp != null ? tmp.next : null;
            if (tmp != null) tmp.next = null;
        }
        return ans;
    }
    @Test
    public void test(){
        ListNode n3=new ListNode(3);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        splitListToParts(n1,5);
    }
}
