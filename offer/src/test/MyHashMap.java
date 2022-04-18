package test;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {
    private static final int BASE=769;
    private LinkedList<int[]>[]data;
    public MyHashMap() {
    data=new LinkedList[BASE];
        for (int i = 0; i <BASE; i++) {
            data[i]=new LinkedList<int[]>();
        }
    }

    public void put(int key, int value) {
    int h=hash(key);
    Iterator<int[]>iterator=data[h].iterator();
    while (iterator.hasNext())
    {
        int[]temp=iterator.next();
        if(temp[0]==key)
        {
           temp[1]=value;
           return;
        }
    }
    data[h].offerLast(new int[]{key,value});
    }
    public int hash(int key)
    {
        return key%BASE;
    }
    public int get(int key) {
        int h=hash(key);
        Iterator<int[]>iterator=data[h].iterator();
        while (iterator.hasNext())
        {
            int[]temp=iterator.next();
            if(temp[0]==key)
            {
                return temp[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h=hash(key);
        Iterator<int[]>iterator=data[h].iterator();
        while (iterator.hasNext())
        {
            int[]temp=iterator.next();
            if(temp[0]==key)
            {
                data[h].remove(temp);
            }
        }

    }
}
