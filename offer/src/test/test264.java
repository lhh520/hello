package test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class test264 {
    public int nthUglyNumber(int n) {
    int[]factors=new int[]{2,3,5};
    Set<Long> seen=new HashSet<>();
    PriorityQueue<Long>heap=new PriorityQueue<>();
    seen.add(1L);
    heap.offer(1L);
    int ugly=0;
    for(int i=0;i<n;i++)
    {
        long curr=heap.poll();
         ugly=(int)curr;
        for(int factot:factors)
        {
            long next=curr*factot;
            if(seen.add(next)){
                heap.offer(next);
            }
        }
    }
    return ugly;
    }
}
