import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer,Integer>
    //双向链表的建立
{
    class DLinkedNode
    {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){};
        public DLinkedNode(int _key,int _value)
        {
            key=_key;
            value=_value;
        }
    }
    private Map<Integer,DLinkedNode>cache=new HashMap<Integer,DLinkedNode>();
    public int size;
    public int capacity;//cache的容量
    private DLinkedNode head,tail;
    public LRUCache(int capacity)//初始化了双向链表的节点，初始化了容器的大小以及占用的空间
    {
        this.size=0;
        this.capacity=capacity;
        //使用伪头部和伪尾部节点
        head=new DLinkedNode();
        tail=new DLinkedNode();
    }
    public int get(int key) {
    DLinkedNode node=cache.get(key);//先从hashmap中获取节点
     if(node==null)
     {
        return -1;//当前值不在cache中
     }
     //如果key存在，应该移动到头部
        moveToHead(node);
     return node.value;
    }

    public void put(int key, int value)
    {
        //查询下是否在cache中
        DLinkedNode node=cache.get(key);
        //如果不在，则创建
        if(node==null)
        {   //创建并且放在哈希表和双向链表中
            DLinkedNode newnode=new DLinkedNode(key,value);
            cache.put(key,newnode);
            addTohead(newnode);
            ++size;//存的节点数量增加1
            //当超出当前的容量时候，应该删除双向链表的尾部节点
            if(size>capacity)
            {
                DLinkedNode tail=removeTail();
                cache.remove(tail.key);
                --size;
            }
        }
        else
        {
            node.value=value;
            moveToHead(node);
        }
    }
    public void addTohead(DLinkedNode node)//
    {
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    public void removeNode(DLinkedNode node)
    {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void moveToHead(DLinkedNode node)
    {
        removeNode(node);
        addTohead(node);
    }
    public DLinkedNode removeTail()
    {
        DLinkedNode res=tail.prev;
        removeNode(res);
        return res;
    }
    @Test
    public void test()
    {
        LRUCache lRUCache=new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }
}
/*
* LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
*/