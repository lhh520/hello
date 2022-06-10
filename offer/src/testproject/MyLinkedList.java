package testproject;

import org.junit.Test;

import java.util.List;

public class MyLinkedList {
    class Nod {
        int val;
        Nod next;
        Nod(int x)
        {
            val=x;
            next=null;
        }
        Nod(int val, Nod next)
        {
            this.val=val;
            this.next=next;
        }
    }
    Nod dummy;
    public MyLinkedList() {
        dummy=new Nod(-1);
    }

    public int get(int index) {
        Nod nn=dummy.next;
        while (nn!=null&&index-->0){
            nn=nn.next;
        }
        if(nn!=null){
            return nn.val;
        }else {
            return -1;
        }
    }

    public void addAtHead(int val) {
        Nod newhead=new Nod(val);
        newhead.next=dummy.next;
        dummy.next=newhead;
    }

    public void addAtTail(int val) {
        Nod nn=dummy.next;
        while (nn.next!=null){
            nn=nn.next;
        }
        Nod newtail=new Nod(val);
        nn.next=newtail;
    }

    public void addAtIndex(int index, int val) {
        if(index<=0){
            addAtHead(val);
            return;
        }
        Nod nod=new Nod(val);
        Nod cur=dummy;
        while (index-->0&&cur!=null){
            cur=cur.next;
        }
        if(cur==null){
            addAtTail(val);
        }
        Nod nn=cur.next;
        cur.next=nod;
        nod.next=nn;
    }

    public void deleteAtIndex(int index) {
        if(index<0){
            return;
        }
        Nod nn=dummy.next;
        while (nn.next!=null){
            nn=nn.next;
        }
        nn.next=nn.next.next;
    }
    @Test
    public void test(){
        MyLinkedList my=new MyLinkedList();
        my.addAtHead(1);
        my.addAtTail(3);
        System.out.println(0);
    }
}
