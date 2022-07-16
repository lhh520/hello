package testproject;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    /** Initialize your data structure here. */
    Queue<Integer>queue;
    int sum=0;
    int size;
    public MovingAverage(int size) {
        queue=new LinkedList<>();
        this.size=size;
    }

    public double next(int val) {
        sum+=val;
        queue.add(val);
        if(queue.size()<=this.size){
            return sum*1.0/queue.size();
        }else {
            sum-=queue.peek();
            queue.poll();//弹出最左边的数字
            return sum*1.0/this.size;
        }
    }
}
