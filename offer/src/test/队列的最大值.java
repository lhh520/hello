package test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 队列的最大值 {
    Queue<Integer>queue;
    PriorityQueue<Integer>pq;
    public 队列的最大值() {
        queue=new LinkedList<>();
        pq=new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }

    public int max_value() {
        return pq.size()>0?pq.peek():-1;
    }

    public void push_back(int value) {
        queue.add(value);
        pq.add(value);
    }

    public int pop_front() {

        if(queue.size()>0){
            pq.remove(queue.peek());
            return queue.poll();
        }else return -1;
    }
}
