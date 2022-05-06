package testproject;

import java.util.LinkedList;
import java.util.Queue;

public class 最近的请求次数 {
    Queue<Integer>queue;
    public 最近的请求次数() {
        queue=new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek()<t-3000){
            queue.poll();
        }
        return queue.size();
    }
}
