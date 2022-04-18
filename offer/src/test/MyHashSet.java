package test;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet {
    private static final int BASE=769;
    private LinkedList[] data;
    //
    public MyHashSet() {
    data=new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i]=new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        //先求哈希值
    int h=hash(key);
    //判定是否哈希冲突，如果没有则插入，反之，有哈希冲突，则添加到链表尾部

    Iterator<Integer>iterator=data[h].iterator();
    while (iterator.hasNext())
    {
        Integer element=iterator.next();
        if(element==key)
            return;
    }
    //向末尾添加数字
    data[h].offerLast(key);
    }
    //求取哈希值，对质数取余
    private int hash(int key) {
        return key%BASE;
    }

    public void remove(int key) {
        //先找到当前值
        int h=hash(key);
        Iterator<Integer>iterator=data[h].iterator();
        //找到当前值，并返回
        while (iterator.hasNext())
        {
            Integer element=iterator.next();
            if(element==key)
            {
                data[h].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h=hash(key);
        //求取哈希值，判定然后查链表
        Iterator<Integer>iterator=data[h].iterator();
        while (iterator.hasNext())
        {
            Integer element=iterator.next();
            if(element==key)
                return true;
        }
        return false;
    }
}
